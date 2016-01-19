package com.lodenrogue.swrpg.gmtools.initiative;

public class InitiativeTest {

	public static void main(String[] args) {
		Initiative initiative = new Initiative();
		initiative.addEntity(new Entity(EntityType.NPC, 5, 0));
		initiative.addEntity(new Entity(EntityType.PC, 3, 4));
		initiative.addEntity(new Entity(EntityType.PC, 5, 0));
		initiative.addEntity(new Entity(EntityType.NPC, 3, 5));
		initiative.addEntity(new Entity(EntityType.PC, 1, 3));
		initiative.addEntity(new Entity(EntityType.NPC, 1, 3));

		

		for (Entity e : initiative.getOrder()) {
			System.out.println(e.getType() + " " + e.getSuccess() + " " + e.getAdvantage());
		}

	}

}
