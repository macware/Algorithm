package Math;

public class RotateImage {
	/**
	 * Think about the problem as intuitive as possible. Do not intend to make
	 * any trick to make it simpler. Use the upper left as the coordinator and
	 * keep in mind which should be reserved or changed (row change? column
	 * change?)
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int n = matrix.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
