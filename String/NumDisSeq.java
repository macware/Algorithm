package String;

public class NumDisSeq {

	/*
	 * Fix the target T. Dp on the length of the source S. String Matching:
	 * Usually figure a way out by base and building up (from the length of
	 * source 0 to the actual length). Sometimes it turns out to be a DP fashion
	 * (Filling a two dimension table) and can be reduced space by reusing the
	 * previous result in a decreasing iterative way.
	 */
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S == null || T == null || S.length() == 0)
			return 0;

		int[] count = new int[T.length() + 1];
		count[0] = 1;

		for (int i = 0; i < S.length(); i++) {
			for (int j = T.length(); j >= 1; j--) {
				if (T.charAt(j - 1) == S.charAt(i))
					count[j] += count[j - 1];
			}
		}

		return count[T.length()];
	}

	/*
	 * Target as the row, dp on the length of Source
	 */
	public int numDistinct2(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] dp = new int[T.length() + 1];
		dp[0] = 1;

		for (int i = 0; i < S.length(); i++) {
			for (int j = T.length() - 1; j >= 0; j--) {
				if (S.charAt(i) == T.charAt(j))
					dp[j + 1] += dp[j];
			}
		}

		return dp[T.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
