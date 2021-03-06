package org.projectbyte.factions.event.player;

import org.bukkit.entity.Player;
import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.Faction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerJoinFactionEvent extends FactionEvent {

	/**
	 * The Player that had joined the Faction
	 */
	private Player player;
	
	/**
	 * The Faction in which the player had joined
	 */
	private Faction faction;
	
}
