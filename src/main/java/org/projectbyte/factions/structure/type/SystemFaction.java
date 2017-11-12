package org.projectbyte.factions.structure.type;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.projectbyte.factions.structure.Faction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemFaction extends Faction {

	private boolean deathBan;
	
	/**
	 * Creates a new SystemFaction object with default values
	 * 
	 * @param id - the UUID of the Faction
	 * @param name - the name of the Faction
	 */
	public SystemFaction(UUID id, String name) {
		super(id, name);
		this.deathBan = true;
	}

	@Override
	public void show(Player player) {
		
	}

}
