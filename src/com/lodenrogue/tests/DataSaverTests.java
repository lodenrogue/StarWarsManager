package com.lodenrogue.tests;

import java.util.HashSet;
import java.util.Set;

import com.lodenrogue.swrpg.charactergen.file.DataSaver;
import com.lodenrogue.swrpg.charactergen.file.Saveable;

public class DataSaverTests {

	public void test() {
		Set<Saveable> saveables = new HashSet<>();
		saveables.add(new PersonSaveable());
		saveables.add(new AccountSaveable());

		DataSaver dataSaver = new DataSaver(saveables);
		dataSaver.save("customer.txt");
	}

}
