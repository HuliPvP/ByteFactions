package org.projectbyte.factions.structure;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.projectbyte.factions.structure.claim.Claim;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Faction {
	
	private UUID id;
	
	private String name;
	
	private Set<Claim> claims;
	
	/**
	 * Creates a default Faction object
	 * 
	 * @param id - the UUID of the Faction
	 * @param name - the name of the Faction
	 */
	public Faction(UUID id, String name) {
		this.id = id;
		if (id == null) {
			this.id = UUID.randomUUID();
		}
		
		this.name = name;
		
		this.claims = new HashSet<>();
	}
	
	/**
	 * Add a claim that is already created
	 * 
	 * @param claim - a Claim you wish to add to the Faction
	 */
	public void addClaim(Claim claim) {
		this.claims.add(claim);
	}
	
	/**
	 * Creates a new {@link Claim} and then stores it to the Factions
	 * 
	 * @param id - the UUID of the claim
	 * @param cornerOne - the first corner Location of the Claim
	 * @param cornerTwo - the second corner Location of the Claim
	 * @param deathBan - whether or not the Claim should be a deathban claim
	 */
	public void addClaim(UUID id, Location cornerOne, Location cornerTwo, boolean deathBan) {
		this.claims.add(new Claim(id, cornerOne, cornerTwo, this, deathBan));
	}
	
	/**
	 * Remove a claim from the Faction
	 * 
	 * @param claim - the Claim you wish to remove
	 */
	public void removeClaim(Claim claim) {
		this.claims.remove(claim);
	}
	
	/**
	 * Used to send the show message to the player
	 * 
	 * @param player - send the /f show message to the Player
	 */
	public abstract void show(Player player);
	
}
