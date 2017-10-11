package org.projectbyte.factions.event.main;

import org.bukkit.entity.Player;
import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.Faction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FactionDisbandEvent extends FactionEvent {

	/**
	 * Faction which was disbanded
	 */
	private Faction faction;
	
	/**
	 * Player that disbanded the Faction
	 */
	private Player player;

}
