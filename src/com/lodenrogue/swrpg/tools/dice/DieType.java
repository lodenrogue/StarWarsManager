package com.lodenrogue.swrpg.tools.dice;

public enum DieType {
	BOOST(6), SETBACK(6), ABILITY(8), DIFFICULTY(8), PROFICIENCY(12), CHALLENGE(12), FORCE(12);

	private int sides;

	private DieType(int sides) {
		this.sides = sides;
	}

	public int getSides() {
		return sides;
	}
}
