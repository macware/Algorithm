package String;

import java.util.*;

// Chapter 1
public class StrOperations {

	public static String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static boolean isPermut(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		return sort(str1).equals(sort(str2));
	}

	public static boolean isPermutUsingCounts(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int[] letters = new int[256];
		int c, i;
		for (i = 0; i < str1.length(); i++) {
			c = (int) str1.charAt(i);
			letters[c]++;
		}

		for (i = 0; i < str2.length(); i++) {
			c = (int) str2.charAt(i);
			letters[c]--;
			/* this is a blind point */
			if (letters[c] < 0)
				return false;
		}

		for (i = 0; i < letters.length; i++) {
			if (letters[i] != 0)
				return false;
		}

		return true;
	}

	public static String compress(String str) {
		if (str == null || str.length() == 0)
			return null;

		StringBuilder sb = new StringBuilder(str.length());
		char c = str.charAt(0);
		sb.append(c);

		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
			else {
				/* a new character */
				c = str.charAt(i);
				sb.append(count);
				sb.append(c);
				count = 1;
			}
		}

		sb.append(count);
		return sb.toString();
	}

	public String compress2(String s) {
		if (s == null || s.length() == 0)
			return "";

		char tag = s.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != tag) {
				sb.append(tag);
				sb.append(count);
				if (sb.length() >= s.length())
					return s;
				tag = s.charAt(i);
				count = 1;
			} else
				count++;
		}

		sb.append(tag);
		sb.append(count);

		if (sb.length() >= s.length())
			return s;

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StrOperations so = new StrOperations();
		String s = "a";
		System.out.println(so.compress(s)+" "+so.compress2(s));
	}

}
