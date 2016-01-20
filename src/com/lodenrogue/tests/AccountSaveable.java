package com.lodenrogue.tests;

import java.util.HashMap;
import java.util.Map;

import com.lodenrogue.swrpg.charactergen.file.Saveable;

public class AccountSaveable implements Saveable{

	@Override
	public Map<String, String> getKeyValuePairs() {
		Map<String, String> keyValuePairs = new HashMap<>();
		keyValuePairs.put("number", "123456");
		keyValuePairs.put("overdrawn", "false");
		return keyValuePairs;
	}

	@Override
	public String getName() {
		return "Account";
	}

}
