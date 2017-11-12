package org.projectbyte.factions.event.movement;

import org.bukkit.entity.Player;
import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.claim.Claim;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerLeaveClaimEvent extends FactionEvent {

	/**
	 * The Player that had left the Claim
	 */
	private Player player;
	
	/**
	 * The Claim that the Player had left
	 */
	private Claim claim;
	
}
