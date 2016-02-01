package com.lodenrogue.swrpg.file;

import java.util.Map;

public interface Saveable {
	
	public Map<String, String> getKeyValuePairs();
	
	public String getId();
	

}
