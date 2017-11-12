package org.projectbyte.factions.command.member;

import org.projectbyte.factions.command.FactionCommand;
import org.projectbyte.factions.util.commandapi.Command;
import org.projectbyte.factions.util.commandapi.CommandArgs;

public class FactionCreate extends FactionCommand {
	
	@Command(name = "faction.create", description = "Create a faction", aliases = { "f.create", "t.create", "s.create", "team.create", "squad.create" }, usage = "/<command> <args>", playerOnly = true)
	public void onCommand(CommandArgs commandArgs) {
		if (commandArgs.length() != 1) {
			
		}
	}

}