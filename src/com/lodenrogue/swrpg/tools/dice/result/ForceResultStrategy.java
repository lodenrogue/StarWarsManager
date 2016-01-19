package com.lodenrogue.swrpg.tools.dice.result;

import java.util.ArrayList;
import java.util.List;

public class ForceResultStrategy implements ResultStrategy {

	@Override
	public List<Result> getResults(int roll) {
		List<Result> results = new ArrayList<>();
		if (roll <= 6) {
			results.add(Result.DARK);
		}
		else if (roll == 7) {
			results.add(Result.DARK);
			results.add(Result.DARK);
		}
		else if (roll == 8 || roll == 9) {
			results.add(Result.LIGHT);
		}
		else if (roll == 10 || roll == 11 || roll == 12) {
			results.add(Result.LIGHT);
			results.add(Result.LIGHT);
		}
		return results;
	}

}
