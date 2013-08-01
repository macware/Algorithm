package String;

public class LonPalidrome {

	/*
	 * Longest palindromic substring in S Choose the straight forward metric and
	 * not to measure slickly in the technique interview. You'd better calculate
	 * the correct length.
	 */
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (s.length() <= 1)
			return s;

		int start, end, newLen, maxLen;
		int i, p, q;

		newLen = maxLen = 0;
		start = end = 0;

		for (i = 0; i < s.length(); i++) {
			// count for the odd case
			p = i - 1;
			q = i + 1;

			while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
				newLen++;
				p--;
				q++;
			}

			newLen = 2 * newLen + 1;
			if (maxLen < newLen) {
				maxLen = newLen;
				start = p + 1;
				end = q - 1;
			}
			newLen = 0;

			// count for the even case
			p = i;
			q = i + 1;
			while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
				newLen++;
				p--;
				q++;
			}

			newLen = 2 * newLen;
			if (maxLen < newLen) {
				maxLen = newLen;
				start = p + 1;
				end = q - 1;
			}
			newLen = 0;

		}

		return s.substring(start, end + 1);

	}

	public String longestPalindrome2(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int b, e, maxLen;
		boolean[][] isPalid = new boolean[s.length()][s.length()];

		b = 0;
		e = s.length();
		maxLen = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j <= i + 2 || isPalid[i + 1][j - 1])) {
					int newLen = j - i + 1;
					if (maxLen < newLen) {
						b = i;
						e = j + 1;
						maxLen = newLen;
					}

					isPalid[i][j] = true;
				}
			}
		}

		return s.substring(b, e);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LonPalidrome lp = new LonPalidrome();
		System.out.println(lp.longestPalindrome2(""));
	}

}
