package com.lodenrogue.swrpg.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

public class DataLoader {

	public JSONObject load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = "";
		String source = "";

		while ((line = reader.readLine()) != null) {
			source += line;
		}
		reader.close();
		return new JSONObject(source);
	}

}
