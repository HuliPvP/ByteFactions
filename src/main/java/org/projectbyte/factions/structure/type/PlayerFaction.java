package org.projectbyte.factions.structure.type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.projectbyte.factions.structure.Faction;
import org.projectbyte.factions.structure.claim.Claim;
import org.projectbyte.factions.structure.member.Role;
import org.projectbyte.factions.structure.relation.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerFaction extends Faction {
	
	private Location home;
	
	private UUID leader;
	
	private Set<UUID> invites;
	
	private Set<Claim> claims;
	
	private Set<Faction> pendingAllies;
	
	private Map<Faction, Relation> relatedFactions;
	
	private Map<UUID, Role> members;
	
	private double dtr, balance;

	/**
	 * Creates a default {@link PlayerFaction} with no values except the important ones
	 * 
	 * @param id - the UUID of the Faction
	 * @param leader - the UUID of the Player who created the Faction
	 * @param name - the Name of the Faction
	 */
	public PlayerFaction(UUID id, UUID leader, String name) {
		super(id, name);
		this.leader = leader;
		this.home = null;
		
		this.invites = new HashSet<>();
		this.claims = new HashSet<>();
		this.pendingAllies = new HashSet<>();
		
		this.relatedFactions = new HashMap<>();
		this.members = new HashMap<>();
		
		this.members.put(leader, Role.LEADER);
		
		this.balance = 0;
		this.dtr = 1.1;
	}

	@Override
	public void show(Player player) {
		// TODO: send show message
	}
	
	/**
	 * Get's a <tt>Set</tt> of UUIDs of all the online players on the server<br>
	 * Will return an empty <tt>Set</tt> if there no online players found
	 * 
	 * @return Set - a Set of UUIDs of all online players in the Faction
	 */
	public Set<UUID> getOnlinePlayers() {
		return this.members.keySet().stream().filter(uuid -> Bukkit.getPlayer(uuid) != null).collect(Collectors.toSet());
	}
	
	/**
	 * Sends the provided message to all online players in the Faction<br>
	 * Automatically translates the color codes so you don't need to when you call the method
	 * 
	 * @param message - the Message you wish to send to all the online players
	 */
	public void sendMessage(String message) {
		this.getOnlinePlayers().stream().forEach(uuid -> Bukkit.getPlayer(uuid).sendMessage(ChatColor.translateAlternateColorCodes('&', message)));
	}

}
