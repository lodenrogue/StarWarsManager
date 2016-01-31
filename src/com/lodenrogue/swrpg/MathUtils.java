package com.lodenrogue.swrpg;

public class MathUtils {
	private MathUtils() {

	}

	public static int parseInt(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		}
		catch (NumberFormatException ex) {
			return defaultValue;
		}
	}

}
