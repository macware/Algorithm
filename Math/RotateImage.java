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

	public void rotate2(int[][] image) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (image == null)
			return;

		int tmp;
		for (int i = 0; i < image.length / 2; i++) {
			for (int j = i; j < image.length - i - 1; j++) {
				tmp = image[i][j];
				image[i][j] = image[image.length - j - 1][i];
				image[image.length - j - 1][i] = image[image.length - i - 1][image.length
						- j - 1];
				image[image.length - i - 1][image.length - j - 1] = image[j][image.length
						- i - 1];
				image[j][image.length - i - 1] = tmp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateImage ri = new RotateImage();
		ri.rotate2(new int[][] { { 1, 2 }, { 3, 4 } });
	}

}
