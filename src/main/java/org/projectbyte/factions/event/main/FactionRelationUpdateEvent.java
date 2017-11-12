package org.projectbyte.factions.event.main;

import org.projectbyte.factions.event.FactionEvent;
import org.projectbyte.factions.structure.Faction;
import org.projectbyte.factions.structure.relation.Relation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FactionRelationUpdateEvent extends FactionEvent {
	
	/**
	 * The Faction that had made the Relation update
	 */
	private Faction updatedFaction;
	
	/**
	 * The Faction that had their relation changed with another Faction
	 */
	private Faction otherFaction;
	
	/**
	 * The old Relation between the two Factions
	 */
	private Relation oldRelation;
	
	/**
	 * The new Relation between the two Factions
	 */
	private Relation newRelation;

}
