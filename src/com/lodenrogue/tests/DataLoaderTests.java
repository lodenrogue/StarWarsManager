package com.lodenrogue.tests;

import java.io.IOException;

import com.lodenrogue.swrpg.charactergen.file.DataLoader;

public class DataLoaderTests {

	public void test() {
		DataLoader loader = new DataLoader();
		try {
			loader.load("customer.txt");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
