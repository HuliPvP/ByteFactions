package org.projectbyte.factions.event.main;

import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.Faction;
import org.projectbyte.factions.structure.claim.Claim;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FactionUnclaimEvent extends FactionEvent {
	
	/**
	 * The Claim that was unclaimed, sounds weird
	 */
	private Claim claim;
	
	/**
	 * The Faction that unclaimed the claim, sounds weird, again<br>
	 * Alternatively you could do {@link Claim#getOwner()} but I'm too lazy to do that, again
	 */
	private Faction faction;

}
