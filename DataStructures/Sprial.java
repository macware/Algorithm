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
			return null;
		
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
