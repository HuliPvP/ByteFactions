package org.projectbyte.factions.structure.claim;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.projectbyte.factions.manager.ClaimManager;
import org.projectbyte.factions.structure.Faction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Claim {
	
	private UUID id;
	
	private Location cornerOne, cornerTwo;
	
	private Faction owner;
	
	private boolean deathBan;
	
	/**
	 * Returns <tt>true</tt> if the provided Location is inside the claim.<br>
	 * However, it returns <tt>false</tt> if the provided Location is not inside the claim
	 * 
	 * @param location - the Location in which you wish to see is inside the claim
	 * @return boolean - Whether or not the provided Location is inside the claim or not
	 */
	public boolean isInsideClaim(Location location) {
		return (location.getX() >= Math.min(cornerOne.getX(), cornerTwo.getX()))
				&& (location.getZ() >= Math.min(cornerOne.getZ(), cornerTwo.getZ()))
				&& (location.getX() <= Math.max(cornerOne.getX(), cornerTwo.getX()))
				&& (location.getZ() <= Math.max(cornerOne.getZ(), cornerTwo.getZ()));
	}
	
	/**
	 * Returns <tt>true</tt> if the Player's location is inside the claim.<br>
	 * However, it returns <tt>false</tt> if the Player's location is not inside the claim
	 * <p>
	 * It's just a faster way instead of doing {@link isInsideClaim(player.getLocation)}, cuz
	 * I'm just that lazy
	 * 
	 * @param player - the Player in which you wish to see is inside the claim
	 * @return boolean - Whether or not the player's location is inside the claim or not
	 * @see {@link ClaimManager#getClaimAt(Location)}
	 */
	public boolean isInsideClaim(Player player) {
		return isInsideClaim(player.getLocation());
	}

}
