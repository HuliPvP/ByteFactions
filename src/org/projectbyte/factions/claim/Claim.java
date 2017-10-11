package org.projectbyte.factions.claim;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.projectbyte.factions.structure.Faction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Claim {
	
	private Location cornerOne, cornerTwo;
	
	private Faction owner;
	
	/**
	 * Returns <tt>true</tt> if the provided Location is inside the claim<p>
	 * Returns <tt>false</tt> if the provided Location is not inside the claim
	 * 
	 * @param location - the Location in which you wish to see is inside the claim
	 * @return boolean - Whether or not the provided Location is inside the claim or not
	 */
	public boolean isInsideClaim(Location location) {
		return (location.getX() > Math.min(cornerOne.getX(), cornerTwo.getX())) && (location.getY() > Math.min(cornerOne.getY(), cornerTwo.getY()))
				&& (location.getZ() > Math.min(cornerOne.getZ(), cornerTwo.getZ())) && (location.getX() < Math.max(cornerOne.getX(), cornerTwo.getX()))
				&& (location.getY() < Math.max(cornerOne.getY(), cornerTwo.getY())) && (location.getZ() < Math.max(cornerOne.getZ(), cornerTwo.getZ()));
	}
	
	/**
	 * Returns <tt>true</tt> if the Player's location is inside the claim
	 * Returns <tt>false</tt> if the Player's location is not inside the claim
	 * TODO: Alternatively, use {@link ClaimManager#getClaimAt()}
	 * 
	 * @param player - the Player in which you wish to see is inside the claim
	 * @return boolean - Whether or not the player's location is inside the claim or not
	 */
	public boolean isInsideClaim(Player player) {
		return isInsideClaim(player.getLocation());
	}

}
