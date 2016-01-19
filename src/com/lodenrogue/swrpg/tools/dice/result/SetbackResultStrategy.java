package com.lodenrogue.swrpg.tools.dice.result;

import java.util.ArrayList;
import java.util.List;

public class SetbackResultStrategy implements ResultStrategy {

	@Override
	public List<Result> getResults(int roll) {
		List<Result> results = new ArrayList<>();
		if (roll <= 2) {
			results.add(Result.BLANK);
		}
		else if (roll == 3 || roll == 4) {
			results.add(Result.FAILURE);
		}
		else if (roll == 5 || roll == 6) {
			results.add(Result.THREAT);
		}
		return results;
	}

}
