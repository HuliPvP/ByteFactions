package org.projectbyte.factions.manager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;
import org.projectbyte.factions.structure.Faction;
import org.projectbyte.factions.structure.claim.Claim;

import lombok.Getter;

@Getter
public class ClaimManager {
	
	private Set<Claim> claims;
	
	/**
	 * Just initializes all of the private fields so they're not null
	 * Nothing surprising
	 */
	public ClaimManager() {
		
		claims = new HashSet<>();
		
	}
	
	/**
	 * Will return <tt>null</tt> if no Claim is found at that certain Location
	 * provided
	 * 
	 * @param location - the Location you wish to find a claim at
	 * @return Claim - A claim that is found surrounding the provided location
	 * @see {@link Claim#isInsideClaim(Location)}
	 */
	public Claim getClaimAt(Location location) {
		return claims.stream().filter(claim -> claim.isInsideClaim(location)).findFirst().orElse(null);
	}
	
	/**
	 * Will return <tt>null</tt> is no Claim is found with a matching UUID
	 * 
	 * @param id - the UUID of the claim you wish to find
	 * @return claim - A claim with the matching UUID as the one provided
	 * @see {@link Claim#getId()}
	 */
	public Claim getClaimById(UUID id) {
		return claims.stream().filter(claim -> claim.getId() == id).findFirst().orElse(null);
	}
	
	/**
	 * Attempts to find a claim with the same owner Faction as the provided Faction<br>
	 * Will return <tt>null</tt> if no Claim with the same owner Faction is not found
	 * 
	 * @param owner - the Faction you wish to see has a claim
	 * @return Claim - A claim with the same owner Faction as the one provided
	 * @see {@link Claim#getOwner()}
	 */
	public Claim getClaimByFaction(Faction owner) {
		return claims.stream().filter(claim -> claim.getOwner() == owner).findFirst().orElse(null);
	}
	
	/**
	 * Adds a Claim to the <tt>Set</tt> of claims if the Claim is already created
	 * 
	 * @param claim - the Claim you wish to store
	 */
	public void addClaim(Claim claim) {
		claims.add(claim);
	}
	
	/**
	 * Instantiates a new claim and then stores it to the <tt>Set</tt>
	 * 
	 * @param id - the UUID of the claim
	 * @param cornerOne - the first corner Location of the claim
	 * @param cornerTwo - the second corner Location of the claim
	 * @param owner - the owner Faction of the claim
	 * @param deathBan - whether or not the Claim should be a deathban claim
	 */
	public void addClaim(UUID id, Location cornerOne, Location cornerTwo, Faction owner, boolean deathBan) {
		claims.add(new Claim(id, cornerOne, cornerTwo, owner, deathBan));
	}
	
	
	/**
	 * Simply removes a claim stores in the Set
	 * 
	 * @param claim - the Claim you wish to remove
	 */
	public void removeClaim(Claim claim) {
		claims.remove(claim);
	}
	
}
