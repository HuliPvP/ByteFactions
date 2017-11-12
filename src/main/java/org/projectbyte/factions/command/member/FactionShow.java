package org.projectbyte.factions.command.member;

import org.projectbyte.factions.command.FactionCommand;
import org.projectbyte.factions.util.commandapi.Command;
import org.projectbyte.factions.util.commandapi.CommandArgs;

public class FactionShow extends FactionCommand {
	
	@Command(name = "faction.show", description = "Get the information of a  Faction", aliases = { "f.show", "t.show", "s.show", "team.show", "squad.show", "f.i", "f.info", "factions.info", "f.who", "factions.who" }, usage = "/<command> <args>")
	public void onCommand(CommandArgs commandArgs) {
		
	}

}
