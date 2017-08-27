package tool;

import java.util.Random;
import java.util.TreeSet;

public class RandomString {
	public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";

	public static String getRandomString(int length) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	public static void setRandomTopic(String s) {
		base = s;
	}
}
