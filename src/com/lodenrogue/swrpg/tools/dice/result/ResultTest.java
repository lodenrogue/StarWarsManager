package com.lodenrogue.swrpg.tools.dice.result;

import java.util.ArrayList;
import java.util.List;

import com.lodenrogue.swrpg.tools.dice.DiceUtils;
import com.lodenrogue.swrpg.tools.dice.Die;
import com.lodenrogue.swrpg.tools.dice.DieType;

public class ResultTest {

	public static void main(String[] args) {
		List<Die> dice = new ArrayList<>();
		dice.add(new Die(DieType.BOOST));
		dice.add(new Die(DieType.SETBACK));
		dice.add(new Die(DieType.ABILITY));
		dice.add(new Die(DieType.DIFFICULTY));
		dice.add(new Die(DieType.PROFICIENCY));
		dice.add(new Die(DieType.CHALLENGE));
		dice.add(new Die(DieType.FORCE));

		dice.forEach(d -> System.out.println(d.getType() + " " + d.roll()));
		System.out.println("Net results: " + DiceUtils.getNetResults(dice));
	}
}
