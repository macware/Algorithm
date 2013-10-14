package Search;

import java.util.*;

public class WordBreak1 {

	public boolean breaking(String s, Set<String> dict,
			Map<String, Boolean> cache) {
		if (s.length() == 0)
			return true;
		if (cache.containsKey(s))
			return cache.get(s);

		boolean res = false;
		String tmp;

		for (int i = 1; i <= s.length(); i++) {
			tmp = s.substring(0, i);
			if ((dict.contains(tmp) || (cache.containsKey(tmp) && cache
					.get(tmp) == true))
					&& breaking(s.substring(i), dict, cache)) {
				res = true;
				break;
			}
		}

		cache.put(s, res);
		return res;
	}

	public boolean wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;

		HashMap<String, Boolean> cache = new HashMap<String, Boolean>();
		return breaking(s, dict, cache);
	}

	/*
	 * The best
	 */
	public boolean wordBreak_dp(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;

		boolean[][] seg = new boolean[s.length()][s.length() + 1];
		int len, i, j;
		String tmp;
		for (len = 1; len <= s.length(); len++) {
			for (i = 0; i <= s.length() - len; i++) {
				tmp = s.substring(i, i + len);
				if (dict.contains(tmp)) {
					seg[i][len] = true;
					continue;
				}

				for (j = 1; j < len; j++) {
					if (seg[i][j] && seg[i + j][len - j]) {
						seg[i][len] = true;
						break;
					}
				}
			}
		}

		return seg[0][s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
	}

}
