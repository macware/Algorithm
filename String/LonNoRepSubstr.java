package String;

import java.util.HashMap;

public class LonNoRepSubstr {

	/*
	 * Longest substring without repeating characters If possible, use an
	 * example to test your thought and find some blind mistakes Think carefully
	 * when you decide to start a new round, reset or backtrack? Did you really
	 * finish all the work after the main loop. (Counting problem needs final
	 * check) How to slickly detect a old record. (Record a valid pos/time,
	 * indicating a valid start point)
	 */
	public static int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

		int newLen, max;
		int validPos = 0;
		max = newLen = 0;

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (chars.containsKey(c) && chars.get(c) >= validPos) {
				if (newLen > max)
					max = newLen;

				validPos = chars.get(c) + 1;
				newLen = i - validPos;
			}

			chars.put(c, i);
			newLen++;
		}

		if (newLen > max)
			max = newLen;

		return max;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
