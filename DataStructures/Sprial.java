package DataStructures;

import java.util.*;

public class Sprial {

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return res;

		int left, right, up, down;
		left = 0;
		right = matrix[0].length - 1;

		up = 0;
		down = matrix.length - 1;

		int i = 0;
		while (true) {
			for (i = left; i <= right; i++)
				res.add(matrix[up][i]);
			up++;

			if (up > down)
				break;

			for (i = up; i <= down; i++)
				res.add(matrix[i][right]);
			right--;

			if (left > right)
				break;

			for (i = right; i >= left; i--)
				res.add(matrix[down][i]);
			down--;

			if (up > down)
				break;

			for (i = down; i >= up; i--)
				res.add(matrix[i][left]);
			left++;

			if (left > right)
				break;
		}

		return res;
	}

	public int[][] spiralOrder_square(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 0)
			return new int[0][];

		int left, right, up, down;
		left = 0;
		right = n - 1;

		up = 0;
		down = n - 1;

		int i = 0, t = 0;
		int[][] matrix = new int[n][n];
		if (n == 0)
			return matrix;

		while (true) {
			for (i = left; i <= right; i++)
				matrix[up][i] = (++t);
			up++;

			if (up > down)
				break;

			for (i = up; i <= down; i++)
				matrix[i][right] = (++t);
			right--;

			if (left > right)
				break;

			for (i = right; i >= left; i--)
				matrix[down][i] = (++t);
			down--;

			if (up > down)
				break;

			for (i = down; i >= up; i--)
				matrix[i][left] = (++t);
			left++;

			if (left > right)
				break;
		}

		return matrix;
	}

	/**
	 * simplified
	 * 
	 */
	public ArrayList<Integer> spiralOrder2(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int left, up, right, down;
		left = up = 0;
		down = matrix.length - 1;

		ArrayList<Integer> res = new ArrayList<Integer>();
		if (down < 0)
			return res;
		right = matrix[0].length - 1;

		int i = 0;
		while (true) {
			for (i = left; i <= right; i++)
				res.add(matrix[up][i]);
			if (++up > down)
				break;

			for (i = up; i <= down; i++)
				res.add(matrix[i][right]);
			if (--right < left)
				break;

			for (i = right; i >= left; i--)
				res.add(matrix[down][i]);
			if (--down < up)
				break;

			for (i = down; i >= up; i--)
				res.add(matrix[i][left]);
			if (++left > right)
				break;
		}

		return res;
	}

	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0)
			return new int[0][];

		int[][] res = new int[n][n];
		int left, up, right, down;
		up = left = 0;
		right = down = n - 1;
		int i, k = 1;

		while (true) {
			for (i = left; i <= right; i++)
				res[up][i] = k++;
			if (++up > down)
				break;

			for (i = up; i <= down; i++)
				res[i][right] = k++;
			if (--right < left)
				break;

			for (i = right; i >= left; i--)
				res[down][i] = k++;
			if (--down < up)
				break;

			for (i = down; i >= up; i--)
				res[i][left] = k++;
			if (++left > right)
				break;
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] { { 1, 2, 0, 3 }, { 5, 6, 4, 7 },
				{ 8, 9, 11, 10 } };
		Sprial sp = new Sprial();

		int[][] res = sp.spiralOrder_square(5);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}

}
