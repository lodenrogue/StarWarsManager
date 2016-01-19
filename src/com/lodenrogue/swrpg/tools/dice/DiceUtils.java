package com.lodenrogue.swrpg.tools.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lodenrogue.swrpg.tools.dice.result.AbilityResultStrategy;
import com.lodenrogue.swrpg.tools.dice.result.BoostResultStrategy;
import com.lodenrogue.swrpg.tools.dice.result.ChallengeResultStrategy;
import com.lodenrogue.swrpg.tools.dice.result.DifficultyResultStrategy;
import com.lodenrogue.swrpg.tools.dice.result.ForceResultStrategy;
import com.lodenrogue.swrpg.tools.dice.result.ProficiencyResultStrategy;
import com.lodenrogue.swrpg.tools.dice.result.Result;
import com.lodenrogue.swrpg.tools.dice.result.ResultStrategy;
import com.lodenrogue.swrpg.tools.dice.result.SetbackResultStrategy;

public class DiceUtils {
	private static Random rand = new Random();

	private DiceUtils() {

	}

	public static List<Result> roll(DieType type) {
		int roll = rand.nextInt(type.getSides()) + 1;

		ResultStrategy strategy = null;
		if (type.equals(DieType.BOOST)) {
			strategy = new BoostResultStrategy();
		}
		else if (type.equals(DieType.SETBACK)) {
			strategy = new SetbackResultStrategy();
		}
		else if (type.equals(DieType.ABILITY)) {
			strategy = new AbilityResultStrategy();
		}
		else if (type.equals(DieType.DIFFICULTY)) {
			strategy = new DifficultyResultStrategy();
		}
		else if (type.equals(DieType.PROFICIENCY)) {
			strategy = new ProficiencyResultStrategy();
		}
		else if (type.equals(DieType.CHALLENGE)) {
			strategy = new ChallengeResultStrategy();
		}
		else if (type.equals(DieType.FORCE)) {
			strategy = new ForceResultStrategy();
		}

		if (strategy != null) {
			return strategy.getResults(roll);
		}
		else {
			return null;
		}
	}

	public static List<Result> getNetResults(List<Die> dice) {
		int advantage = 0;
		int success = 0;
		int triumph = 0;
		int despair = 0;
		int light = 0;
		int dark = 0;

		for (Die die : dice) {
			for (Result result : die.getResult()) {
				if (result.equals(Result.ADVANTAGE)) {
					advantage++;
				}
				else if (result.equals(Result.THREAT)) {
					advantage--;
				}
				else if (result.equals(Result.SUCCESS)) {
					success++;
				}
				else if (result.equals(Result.FAILURE)) {
					success--;
				}
				else if (result.equals(Result.TRIUMPH)) {
					success++;
					triumph++;
				}
				else if (result.equals(Result.DESPAIR)) {
					success--;
					despair++;
				}
				else if (result.equals(Result.LIGHT)) {
					light++;
				}
				else if (result.equals(Result.DARK)) {
					dark++;
				}
			}
		}

		List<Result> results = new ArrayList<>();
		if (success > 0) {
			results.addAll(getResults(success, Result.SUCCESS));
		}
		else if (success < 0) {
			results.addAll(getResults(Math.abs(success), Result.FAILURE));
		}

		if (advantage > 0) {
			results.addAll(getResults(advantage, Result.ADVANTAGE));
		}
		else if (advantage < 0) {
			results.addAll(getResults(Math.abs(advantage), Result.THREAT));
		}

		if (triumph > 0) {
			results.addAll(getResults(triumph, Result.TRIUMPH));
		}

		if (despair > 0) {
			results.addAll(getResults(despair, Result.DESPAIR));
		}

		if (light > 0) {
			results.addAll(getResults(light, Result.LIGHT));
		}

		if (dark > 0) {
			results.addAll(getResults(dark, Result.DARK));
		}

		return results;
	}

	private static List<Result> getResults(int count, Result result) {
		List<Result> results = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			results.add(result);
		}
		return results;
	}
}
