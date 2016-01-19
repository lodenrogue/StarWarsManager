package com.lodenrogue.swrpg.tools.dice.result;

import java.util.ArrayList;
import java.util.List;

public class ProficiencyResultStrategy implements ResultStrategy {

	@Override
	public List<Result> getResults(int roll) {
		List<Result> results = new ArrayList<>();
		if (roll == 1) {
			results.add(Result.BLANK);
		}
		else if (roll == 2 || roll == 3) {
			results.add(Result.SUCCESS);
		}
		else if (roll == 4 || roll == 5) {
			results.add(Result.SUCCESS);
			results.add(Result.SUCCESS);
		}
		else if (roll == 6) {
			results.add(Result.ADVANTAGE);
		}
		else if (roll == 7 || roll == 8 || roll == 9) {
			results.add(Result.SUCCESS);
			results.add(Result.ADVANTAGE);
		}
		else if (roll == 10 || roll == 11) {
			results.add(Result.ADVANTAGE);
			results.add(Result.ADVANTAGE);
		}
		else if (roll == 12) {
			results.add(Result.TRIUMPH);
		}
		return results;
	}

}
