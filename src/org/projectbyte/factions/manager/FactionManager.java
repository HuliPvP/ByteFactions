package org.projectbyte.factions.manager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.projectbyte.factions.structure.Faction;
import org.projectbyte.factions.structure.claim.Claim;
import org.projectbyte.factions.structure.type.PlayerFaction;
import org.projectbyte.factions.structure.type.SystemFaction;
import org.projectbyte.factions.util.UUIDGetter;

public class FactionManager {
	
	private Set<Faction> factions;
	
	/**
	 * Instantiates the Faction manager to make sure the fields aren't null
	 */
	public FactionManager() {
		
		factions = new HashSet<>();
		
	}
	
	/**
	 * Get all of the loaded PlayerFactions on the server.<br>
	 * Will return an empty <tt>Set</tt> if no PlayerFactions are found
	 * 
	 * @return Set - a Set of all PlayerFaction objects currently loaded on the server
	 */
	public Set<PlayerFaction> getAllPlayerFactions() {
		return factions.stream().filter(faction -> faction instanceof PlayerFaction).map(PlayerFaction.class::cast).collect(Collectors.toSet());
	}
	
	/**
	 * Get all of the loaded SystemFactions on the server.<br>
	 * Will return an empty <tt>Set</tt> if no SystemFactions are found
	 * 
	 * @return Set - a Set of all SystemFaction objects currently loaded on the server
	 */
	public Set<SystemFaction> getAllSystemFactions() {
		return factions.stream().filter(faction -> faction instanceof SystemFaction).map(SystemFaction.class::cast).collect(Collectors.toSet());
	}
	
	/**
	 * Get a <tt>Faction</tt> by it's UUID
	 * 
	 * @param id - the UUID of the Faction you wish to find
	 * @return Faction - a Faction with the matching UUID as the one provided
	 */
	public Faction getFactionById(UUID id) {
		return factions.stream().filter(faction -> faction.getId() == id).findFirst().orElse(null);
	}
	
	/**
	 * Get a <tt>Faction<tt> by it's name
	 * 
	 * @param name - the Name of the Faction you wish to find
	 * @return Faction - a Faction with the matching name as the one provided
	 */
	public Faction getFactionByName(String name) {
		return factions.stream().filter(faction -> faction.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	/**
	 * Get a <tt>Faction</tt> by searching for one of it's Claims
	 * 
	 * @param claim - the Claim of the Faction you wish to find
	 * @return Faction - a Faction which contains the Claim provided in it's stored claims
	 */
	public Faction getFactionByClaim(Claim claim) {
		return factions.stream().filter(faction -> faction.getClaims().contains(claim)).findFirst().orElse(null);
	}
	
	/**
	 * Get a <tt>PlayerFaction</tt> by providing one of the Member's UUIDs
	 * 
	 * @param playerUuid - the UUID of the Player you wish to find a Faction for
	 * @return PlayerFaction - a PlayerFaction which has a member stored with the same provided UUID
	 */
	public PlayerFaction getFactionByPlayer(UUID playerUuid) {
		return getAllPlayerFactions().stream().filter(playerFaction -> playerFaction.getMembers().containsKey(playerUuid)).findFirst().orElse(null);
	}
	
	/**
	 * Get a <tt>PlayerFaction</tt> by the leader of the Faction
	 * 
	 * @param leaderUuid - the UUID of the leader you wish to find
	 * @return PlayerFaction - a PlayerFaction with the same leader UUID as the one provided
	 */
	public PlayerFaction getFactionByLeader(UUID leaderUuid) {
		return getAllPlayerFactions().stream().filter(playerFaction -> playerFaction.getLeader() == leaderUuid).findFirst().orElse(null);
	}
	
	/**
	 * First attempts to get the Faction by their name and then if that fails, it then attempts
	 * to get the Faction of a player<br>
	 * Will return <tt>null</tt> if no Faction with the name or with that Player wasn't found
	 * 
	 * @param name - the name of the Faction or the name of the Player you wish to find a Faction for
	 * @return Faction - a Faction with the same name or with the Player with that name
	 */
	public Faction getFactionByString(String name) {
		if (getFactionByName(name) != null) {
			return getFactionByName(name);
		}
		UUID uuid = null;
		try {
			uuid = UUIDGetter.getUUIDOf(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uuid != null && getFactionByPlayer(uuid) != null) {
			return getFactionByPlayer(uuid);
		}
		return null;
	}

}
