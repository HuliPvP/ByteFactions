package org.projectbyte.factions.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.projectbyte.factions.ByteFactions;
import org.projectbyte.factions.event.movement.PlayerEnterClaimEvent;
import org.projectbyte.factions.event.movement.PlayerLeaveClaimEvent;
import org.projectbyte.factions.structure.claim.Claim;

public class PlayerMoveListener implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Location to = event.getTo();
		Location from = event.getFrom();
		if (to.getBlockX() != from.getBlockX() || to.getBlockZ() != from.getBlockZ()) {
			Player player = event.getPlayer();
			Claim newClaim = ByteFactions.getInstance().getClaimManager().getClaimAt(to);
			Claim oldClaim = ByteFactions.getInstance().getClaimManager().getClaimAt(from);
			if (newClaim != null) {
				Bukkit.getPluginManager().callEvent(new PlayerEnterClaimEvent(player, newClaim));
			}
			if (oldClaim != null) {
				Bukkit.getPluginManager().callEvent(new PlayerLeaveClaimEvent(player, oldClaim));
			}
		}
	}

}
