package org.projectbyte.factions.structure.relation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Relation {
	
	NONE(0, "None"),
	ENEMY(1, "Enemy"),
	ALLY(2, "Ally");
	
	private int id;
	private String name;

}
