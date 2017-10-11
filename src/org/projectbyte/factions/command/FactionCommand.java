package org.projectbyte.factions.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.projectbyte.factions.ByteFactions;
import org.projectbyte.factions.util.commandapi.Command;
import org.projectbyte.factions.util.commandapi.CommandArgs;

public class FactionCommand {
	
	public ByteFactions plugin = ByteFactions.getInstance();
	
	public FactionCommand() {
		plugin.getCommandFramework().registerCommands(this);
		plugin.getCommandFramework().registerHelp();
	}
	
	@Command(name = "faction", description = "The main command for Factions", aliases = { "f", "t", "s", "team", "squad" }, usage = "/<command> <args>")
	public void onCommand(CommandArgs commandArgs) {
		if (!commandArgs.isPlayer()) {
			commandArgs.getSender().sendMessage(ChatColor.RED + "Sorry. Players only.");
			return;
		}
		
		Player player = (Player) commandArgs.getSender();
		showHelp(player, 1);
	}
	
	public void showHelp(Player player, int page) {
		
	}

}
