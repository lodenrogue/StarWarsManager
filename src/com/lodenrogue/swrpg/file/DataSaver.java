package com.lodenrogue.swrpg.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class DataSaver {
	private Set<Saveable> saveables;

	public DataSaver() {
		saveables = new HashSet<>();
	}

	public DataSaver(Set<Saveable> saveables) {
		this.saveables = saveables;
	}

	public boolean removeSaveable(Saveable saveable) {
		return saveables.remove(saveable);
	}

	public boolean addSaveable(Saveable saveable) {
		return saveables.add(saveable);
	}

	private void save(File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		JSONObject save = new JSONObject();

		for (Saveable s : saveables) {
			Map<String, String> keyValuePairs = s.getKeyValuePairs();
			save.put(s.getId(), keyValuePairs);
		}
		writer.write(save.toString(4));
		writer.close();

	}

	public void save(String pathName) throws IOException {
		if (!pathName.endsWith(".json")) {
			pathName += ".json";
		}
		save(new File(pathName));
	}
}
