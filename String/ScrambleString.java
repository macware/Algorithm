package String;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1 == null && s2 == null)
			return true;

		if (s1 == null || s2 == null)
			return false;

		if (s1.length() != s2.length())
			return false;

		int len = s1.length();
		boolean isScramble[][][] = new boolean[len][len][len + 1];
		int i, j, k, t;

		for (i = 0; i < len; i++)
			for (j = 0; j < len; j++) {
				isScramble[i][j][0] = true;
				isScramble[i][j][1] = (s1.charAt(i) == s2.charAt(j));
			}

		for (k = 2; k <= len; k++)
			for (i = 0; i <= len - k; i++)
				for (j = 0; j <= len - k; j++) {
					isScramble[i][j][k] = false;
					for (t = 1; t <= k; t++) {
						if (isScramble[i][j][t]
								&& isScramble[i + t][j + t][k - t])
							isScramble[i][j][k] = true;

						if (isScramble[i][j + k - t][t]
								&& isScramble[i + t][j][k - t])
							isScramble[i][j][k] = true;

						if (isScramble[i][j][k])
							break;
					}
				}

		return isScramble[0][0][len];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("great", "rgtae"));
	}

}
