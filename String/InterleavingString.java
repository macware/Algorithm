package String;

public class InterleavingString {

	/*
	 * DP: progress on string length, check edge cases -- null, length = 0,
	 * length equals
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1 == null && s2 == null)
			return s3 == null;

		if (s3 == null)
			return false;

		if (s3.length() != s2.length() + s1.length())
			return false;

		if (s1.length() == 0)
			return s3.equals(s2);

		if (s2.length() == 0)
			return s3.equals(s1);

		if (s2.length() > s1.length()) {
			String s = s1;
			s1 = s2;
			s2 = s;
		}

		boolean[] match = new boolean[s2.length() + 1];
		int i, j;

		match[0] = true;
		for (j = 1; j < match.length; j++)
			match[j] = s3.substring(0, j).equals(s2.substring(0, j));

		boolean tmp;
		for (i = 1; i <= s1.length(); i++) {
			for (j = 0; j <= s2.length(); j++) {
				tmp = false;
				if (match[j])
					tmp = (s1.charAt(i - 1) == s3.charAt(i + j - 1));
				if (!tmp && j > 0 && match[j - 1])
					tmp = (s2.charAt(j - 1) == s3.charAt(i + j - 1));

				match[j] = tmp;
			}
		}

		return match[match.length - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
