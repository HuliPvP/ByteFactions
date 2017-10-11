package org.projectbyte.factions.event.main;

import org.bukkit.entity.Player;
import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.Faction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FactionCreateEvent extends FactionEvent {
	
	/**
	 * Faction which was created
	 */
	private Faction faction;
	
	/**
	 * Player who created the Faction
	 */
	private Player player;

}
