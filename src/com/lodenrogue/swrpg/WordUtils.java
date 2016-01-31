package com.lodenrogue.swrpg;

public class WordUtils {

	private WordUtils() {

	}

	public static String capitalize(String word) {
		String w = word.toLowerCase();
		w = w.substring(0, 1).toUpperCase() + w.substring(1);
		return w;
	}

}
