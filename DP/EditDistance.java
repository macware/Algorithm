package DP;

public class EditDistance {

	public int minDistance_save_space(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] dis = new int[word2.length() + 1];
		int[] curdis = new int[word2.length() + 1];
		int i, j;
		for (j = 0; j <= word2.length(); j++)
			dis[j] = j;

		for (i = 1; i <= word1.length(); i++) {
			curdis[0] = i;
			for (j = 1; j <= word2.length(); j++) {
				if (word2.charAt(j - 1) == word1.charAt(i - 1))
					curdis[j] = dis[j - 1];
				else {
					curdis[j] = 1 + Math.min(dis[j - 1],
							Math.min(dis[j], curdis[j - 1]));
				}
			}
			int[] tmp = dis;
			dis = curdis;
			curdis = tmp;
		}

		return dis[word2.length()];

	}

	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] dis = new int[word1.length() + 1][word2.length() + 1];
		int i, j;
		for (j = 0; j <= word2.length(); j++)
			dis[0][j] = j;
		for (i = 0; i <= word1.length(); i++)
			dis[i][0] = i;

		for (i = 1; i <= word1.length(); i++) {
			for (j = 1; j <= word2.length(); j++) {
				if (word2.charAt(j - 1) == word1.charAt(i - 1))
					dis[i][j] = dis[i - 1][j - 1];
				else {
					dis[i][j] = 1 + Math.min(dis[i - 1][j - 1],
							Math.min(dis[i][j - 1], dis[i - 1][j]));
				}
			}
		}

		return dis[word1.length()][word2.length()];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
