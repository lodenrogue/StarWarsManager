package com.lodenrogue.swrpg.tools.dice.result;

import java.util.ArrayList;
import java.util.List;

public class DifficultyResultStrategy implements ResultStrategy {

	@Override
	public List<Result> getResults(int roll) {
		List<Result> results = new ArrayList<>();
		if (roll == 1) {
			results.add(Result.BLANK);
		}
		else if (roll == 2) {
			results.add(Result.FAILURE);
		}
		else if (roll == 3) {
			results.add(Result.FAILURE);
			results.add(Result.FAILURE);
		}
		else if (roll == 4 || roll == 5 || roll == 6) {
			results.add(Result.THREAT);
		}
		else if (roll == 7) {
			results.add(Result.THREAT);
			results.add(Result.THREAT);
		}
		else if (roll == 8) {
			results.add(Result.FAILURE);
			results.add(Result.THREAT);
		}
		return results;
	}

}
