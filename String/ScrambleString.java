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

	public boolean isScramble2(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1 == null && s2 == null)
			return true;

		if (s1 == null || s2 == null)
			return false;

		if (s1.length() != s2.length())
			return false;

		int n = s1.length();
		boolean[][][] scram = new boolean[n][n][n + 1];
		int i, j;

		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				scram[i][j][1] = (s1.charAt(i) == s2.charAt(j));

		int len, k;
		for (len = 2; len <= n; len++) {
			for (i = 0; i <= n - len; i++)
				for (j = 0; j <= n - len; j++)
					for (k = 1; k < len; k++) {
						if ((scram[i][j][k] && scram[i + k][j + k][len - k])
								|| (scram[i][j + len - k][k] && scram[i + k][j][len
										- k])) {
							scram[i][j][len] = true;
							break;
						}
					}
		}

		return scram[0][0][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble2("abc", "bca"));
	}

}
