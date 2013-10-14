package String;

import java.util.*;

public class MinWinStr {

	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (T == null || T.length() == 0)
			return "";

		HashMap<Character, Integer> needs = new HashMap<Character, Integer>();
		HashMap<Character, Integer> has = new HashMap<Character, Integer>();
		int i, count, len = 0;

		for (i = 0; i < T.length(); i++) {
			count = 1;
			if (needs.containsKey(T.charAt(i)))
				count += needs.get(T.charAt(i));
			needs.put(T.charAt(i), count);
		}

		int start = 0, minstart = -1, minLen = Integer.MAX_VALUE, newLen;
		char c;
		for (i = 0; i < S.length(); i++) {
			c = S.charAt(i);
			if (!needs.containsKey(c))
				continue;
			count = 1;
			if (has.containsKey(c))
				count += has.get(c);
			has.put(c, count);

			if (count <= needs.get(c))
				len++;

			if (len == T.length()) {
				while (true) {
					c = S.charAt(start);
					if (!needs.containsKey(c))
						start++;
					else if (has.get(c) > needs.get(c)) {
						start++;
						has.put(c, has.get(c) - 1);
					} else
						break;
				}

				newLen = i - start + 1;
				if (newLen < minLen) {
					minLen = newLen;
					minstart = start;
				}
			}
		}

		if (minstart == -1)
			return "";

		return S.substring(minstart, minstart + minLen);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinWinStr mws = new MinWinStr();
		//System.out.println(mws.minWindow("", "bd"));
		System.out.println((-1)^(-1));
	}

}
