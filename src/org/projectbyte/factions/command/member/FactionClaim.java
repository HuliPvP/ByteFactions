package org.projectbyte.factions.command.member;

import org.projectbyte.factions.command.FactionCommand;
import org.projectbyte.factions.util.commandapi.Command;
import org.projectbyte.factions.util.commandapi.CommandArgs;

public class FactionClaim extends FactionCommand {
	
	@Command(name = "faction.claim", description = "Claim the territory for your faction", aliases = { "f.claim", "t.claim", "s.claim", "team.claim", "squad.claim" }, usage = "/<command> <args>")
	public void onCommand(CommandArgs commandArgs) {
		
	}

}
