package org.projectbyte.factions.structure.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
	
	MEMBER(0, "Member"),
	OFFICER(1, "Officer"),
	CO_OWNER(2, "Co-Owner"),
	LEADER(3, "Leader");
	
	private int level;
	private String name;
}
