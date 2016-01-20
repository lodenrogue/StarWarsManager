package com.lodenrogue.tests;

import java.util.HashMap;
import java.util.Map;

import com.lodenrogue.swrpg.charactergen.file.Saveable;

public class PersonSaveable implements Saveable {

	@Override
	public Map<String, String> getKeyValuePairs() {
		Map<String, String> keyValuePairs = new HashMap<>();
		keyValuePairs.put("name", "Matt");
		keyValuePairs.put("age", "23");
		return keyValuePairs;
	}

	@Override
	public String getName() {
		return "Person";
	}

}
