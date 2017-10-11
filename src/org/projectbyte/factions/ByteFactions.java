package org.projectbyte.factions;

import org.bukkit.plugin.java.JavaPlugin;
import org.projectbyte.factions.manager.ClaimManager;
import org.projectbyte.factions.manager.FactionManager;

import lombok.Getter;

@Getter
public class ByteFactions extends JavaPlugin {
	
	@Getter
	private static ByteFactions instance;
	
	private FactionManager factionManager;
	private ClaimManager claimManager;
	
	public void onEnable() {
		
		instance = this;
		
		factionManager = new FactionManager();
		claimManager = new ClaimManager();
		
	}

}
