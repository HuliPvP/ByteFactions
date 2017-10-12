package org.projectbyte.factions.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.projectbyte.factions.event.main.FactionCreateEvent;

public class FactionListener implements Listener {
	
	@EventHandler
	public void onFactionCreate(FactionCreateEvent event) {
		String message = "";
		Bukkit.broadcastMessage(message);
	}

}
