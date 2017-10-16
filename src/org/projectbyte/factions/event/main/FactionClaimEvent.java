package org.projectbyte.factions.event.main;

import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.Faction;
import org.projectbyte.factions.structure.claim.Claim;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FactionClaimEvent extends FactionEvent {
	
	/**
	 * The Claim that was created
	 */
	private Claim claim;
	
	/**
	 * The Faction that made the claim area<br>
	 * Alternatively, you can do {@link Claim#getOwner()} but I'm just super lazy
	 */
	private Faction faction;

}
