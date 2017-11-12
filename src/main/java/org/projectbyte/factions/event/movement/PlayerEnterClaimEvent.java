package org.projectbyte.factions.event.movement;

import org.bukkit.entity.Player;
import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.claim.Claim;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerEnterClaimEvent extends FactionEvent {

	/**
	 * The Player that had entered the Claim
	 */
	private Player player;
	
	/**
	 * The Claim that the Player had entered
	 */
	private Claim claimEntered;
	
}
