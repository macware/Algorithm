package Search;

public class LongestPalindrome {

	public String longestPalindrome(String s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0)
			return "";

		int start = 0, maxLen = 0, newLen;
		int m, n;
		for (int i = 0; i < s.length(); i++) {
			// even;
			m = i;
			n = i + 1;
			while (m >= 0 && n < s.length()) {
				if (s.charAt(m) != s.charAt(n))
					break;
				m--;
				n++;
			}
			newLen = n - m - 1;
			if (newLen > maxLen) {
				start = m + 1;
				maxLen = newLen;
			}

			// odd;
			m = i - 1;
			n = i + 1;
			while (m >= 0 && n < s.length()) {
				if (s.charAt(m) != s.charAt(n))
					break;
				m--;
				n++;
			}
			newLen = n - m - 1;
			if (newLen > maxLen) {
				start = m + 1;
				maxLen = newLen;
			}
		}

		return s.substring(start, start + maxLen);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
