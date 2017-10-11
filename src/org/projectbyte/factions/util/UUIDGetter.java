package org.projectbyte.factions.util;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UUIDGetter implements Callable<Map<String, UUID>> {
	private final JSONParser jsonParser;
    private final List<String> names;
    private final boolean rateLimiting;

    private UUIDGetter(final List<String> names) {
        this(names, true);
    }

    private UUIDGetter(final List<String> names, final boolean rateLimiting) {
        this.jsonParser = new JSONParser();
        this.names = names;
        this.rateLimiting = rateLimiting;
    }

    private static void writeBody(final HttpURLConnection connection, final String body) throws Exception {
        final OutputStream stream = connection.getOutputStream();
        stream.write(body.getBytes());
        stream.flush();
        stream.close();
    }


    private static HttpURLConnection createConnection() throws Exception {
        final URL url = new URL("https://api.mojang.com/profiles/minecraft");
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        return connection;
    }

    private static UUID getUUID(final String id) {
        return UUID.fromString(id.substring(0, 8) + "-" + id.substring(8, 12) + "-" + id.substring(12, 16) + "-" + id.substring(16, 20) + "-" + id.substring(20, 32));
    }

    public static byte[] toBytes(final UUID uuid) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }

    public static UUID fromBytes(final byte[] array) {
        if (array.length != 16) {
            throw new IllegalArgumentException("Illegal byte array length: " + array.length);
        }
        final ByteBuffer byteBuffer = ByteBuffer.wrap(array);
        final long mostSignificant = byteBuffer.getLong();
        final long leastSignificant = byteBuffer.getLong();
        return new UUID(mostSignificant, leastSignificant);
    }

    public static UUID getUUIDOf(final String name) throws Exception {
        return new UUIDGetter(Collections.singletonList(name)).call().get(name);
    }

    public Map<String, UUID> call() throws Exception {
        final Map<String, UUID> uuidMap = new HashMap<String, UUID>();
        for (int requests = (int) Math.ceil(this.names.size() / 100.0), i = 0; i < requests; ++i) {
            final HttpURLConnection connection = createConnection();
            final String body = JSONArray.toJSONString(this.names.subList(i * 100, Math.min((i + 1) * 100, this.names.size())));
            writeBody(connection, body);
            final JSONArray array = (JSONArray) this.jsonParser.parse(new InputStreamReader(connection.getInputStream()));
            for (final Object profile : array) {
                final JSONObject jsonProfile = (JSONObject) profile;
                final String id = (String) jsonProfile.get("id");
                final String name = (String) jsonProfile.get("name");
                final UUID uuid = getUUID(id);
                uuidMap.put(name, uuid);
            }
            if (this.rateLimiting && i != requests - 1) {
                Thread.sleep(100L);
            }
        }
        return uuidMap;
    }
}