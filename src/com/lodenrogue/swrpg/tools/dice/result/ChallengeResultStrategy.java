package com.lodenrogue.swrpg.tools.dice.result;

import java.util.ArrayList;
import java.util.List;

public class ChallengeResultStrategy implements ResultStrategy {

	@Override
	public List<Result> getResults(int roll) {
		List<Result> results = new ArrayList<>();
		if (roll == 1) {
			results.add(Result.BLANK);
		}
		else if (roll == 2 || roll == 3) {
			results.add(Result.FAILURE);
		}
		else if (roll == 4 || roll == 5) {
			results.add(Result.FAILURE);
			results.add(Result.FAILURE);
		}
		else if (roll == 6 || roll == 7) {
			results.add(Result.THREAT);
		}
		else if (roll == 8 || roll == 9) {
			results.add(Result.FAILURE);
			results.add(Result.THREAT);
		}
		else if (roll == 10 || roll == 11) {
			results.add(Result.THREAT);
			results.add(Result.THREAT);
		}
		else if (roll == 12) {
			results.add(Result.DESPAIR);
		}
		return results;
	}

}
