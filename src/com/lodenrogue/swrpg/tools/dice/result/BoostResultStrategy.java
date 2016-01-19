package com.lodenrogue.swrpg.tools.dice.result;

import java.util.ArrayList;
import java.util.List;

public class BoostResultStrategy implements ResultStrategy {

	@Override
	public List<Result> getResults(int roll) {
		List<Result> results = new ArrayList<>();
		if (roll <= 2) {
			results.add(Result.BLANK);
		}
		else if (roll == 3) {
			results.add(Result.SUCCESS);
		}
		else if (roll == 4) {
			results.add(Result.SUCCESS);
			results.add(Result.ADVANTAGE);
		}
		else if (roll == 5) {
			results.add(Result.ADVANTAGE);
			results.add(Result.ADVANTAGE);
		}
		else if (roll == 6) {
			results.add(Result.ADVANTAGE);
		}
		return results;
	}

}
