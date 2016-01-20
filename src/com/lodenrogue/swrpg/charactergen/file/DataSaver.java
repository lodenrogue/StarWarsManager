package com.lodenrogue.swrpg.charactergen.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class DataSaver {
	private static final String DATA_FOLDER = "data/";
	private Set<Saveable> saveables;

	public DataSaver(Set<Saveable> saveables) {
		this.saveables = saveables;
	}

	public boolean removeSaveable(Saveable saveable) {
		return saveables.remove(saveable);
	}

	public boolean addSaveable(Saveable saveable) {
		return saveables.add(saveable);
	}

	public void save(String fileName) {
		File dataFolder = new File(DATA_FOLDER);
		if (dataFolder.exists() && dataFolder.isDirectory()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FOLDER + fileName));
				JSONObject save = new JSONObject();

				for (Saveable s : saveables) {
					Map<String, String> keyValuePairs = s.getKeyValuePairs();
					save.put(s.getName(), keyValuePairs);
				}
				writer.write(save.toString(4));
				writer.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
