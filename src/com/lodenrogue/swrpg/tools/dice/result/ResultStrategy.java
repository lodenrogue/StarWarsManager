package com.lodenrogue.swrpg.tools.dice.result;

import java.util.List;

@FunctionalInterface
public interface ResultStrategy {

	public List<Result> getResults(int roll);

}
