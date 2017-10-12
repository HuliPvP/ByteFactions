package org.projectbyte.factions.command.member;

import org.projectbyte.factions.command.FactionCommand;
import org.projectbyte.factions.util.commandapi.Command;
import org.projectbyte.factions.util.commandapi.CommandArgs;

public class FactionDisband extends FactionCommand {
	
	@Command(name = "faction.disband", description = "Disband a faction", aliases = { "f.disband", "t.disband", "s.disband", "team.disband", "squad.disband" }, usage = "/<command> <args>")
	public void onCommand(CommandArgs commandArgs) {
		
	}

}
