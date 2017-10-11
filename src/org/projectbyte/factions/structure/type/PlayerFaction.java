package org.projectbyte.factions.structure.type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
	 * Creates a default PlayerFaction with no values except the important ones
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
	
	

}
