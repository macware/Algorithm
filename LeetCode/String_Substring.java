package LeetCode;

import java.util.*;

public class String_Substring {
	
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

	/* 
	 * Longest consecutive subsequence.
	 */
	
	
	/* 
	 * Minimum window substring.
	 */
	
	/*
	 * Longest substring containing at most two distinct characters.
	 */
	
	/* 
	 * Longest palindromic substring. 
	 */
	
	
	/*
	 * Longest Common Prefix. Some times it's not that easy to come up with a
	 * brute force way. The key idea is: think the problem in a natural way, as
	 * straight forward as possible.
	 */
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (strs == null || strs.length == 0 || strs[0].equals(""))
			return "";
		if (strs.length == 1)
			return strs[0];

		int i, j;

		for (j = 0; j < strs[0].length(); j++) {
			for (i = 1; i < strs.length; i++) {
				if (strs[i].length() <= j
						|| strs[i].charAt(j) != strs[0].charAt(j)) {
					System.out.println("j = "+j);
					return strs[0].substring(0, j);
				}
			}
		}

		System.out.println("j = "+j);
		return strs[0].substring(0, j);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String_Substring oj = new String_Substring();
		System.out.println(oj.longestCommonPrefix(new String[]{"","aaa"}));
	}

}
