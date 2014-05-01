package utils;

import java.util.Random;

public class Utils {

	private Utils() {
	}

	public static Random rand = new Random();

	public static int randInt(int min, int max) {
		if (max < min)
			throw new RuntimeException("max is lower than min");
		return rand.nextInt(max - min) + min;
	}

	public static double randDouble(double min, double max) {
		if (max < min)
			throw new RuntimeException("max is lower than min");
		return rand.nextDouble() * (max - min) + min;
	}
	
	public static double randDouble(double max) {
		return rand.nextDouble() * max;
	}

}
