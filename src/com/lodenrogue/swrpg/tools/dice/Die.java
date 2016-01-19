package com.lodenrogue.swrpg.tools.dice;

import java.util.ArrayList;
import java.util.List;

import com.lodenrogue.swrpg.tools.dice.result.Result;

public class Die {
	private DieType type;
	private List<Result> results;

	public Die(DieType type) {
		this.type = type;
		results = new ArrayList<>();
		results.add(Result.BLANK);
	}

	public DieType getType() {
		return type;
	}

	public List<Result> roll() {
		List<Result> roll = DiceUtils.roll(type);
		results.clear();
		results.addAll(roll);
		return getResult();
	}

	public List<Result> getResult() {
		return results;
	}

}
