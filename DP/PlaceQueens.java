package DP;

import java.util.*;

public class PlaceQueens {

	public PlaceQueens() {

	}

	private int gridSize;

	public PlaceQueens(int grid) {
		gridSize = grid;
	}

	private void placing(int row, Integer[] cols, ArrayList<Integer[]> result) {
		if (row == gridSize) {
			result.add(cols.clone());
		} else {
			for (int col = 0; col < gridSize; col++) {
				if (checkValid(row, col, cols)) {
					cols[row] = col;
					placing(row + 1, cols, result);
				}
			}
		}
	}

	private boolean checkValid(int row, int col, Integer[] cols) {
		for (int row2 = 0; row2 < row; row2++) {
			int col2 = cols[row2];
			if (col2 == col)
				return false;

			if (Math.abs(col2 - col2) == (row - row2))
				return false;
		}

		return true;
	}

	/**
	 * Leetcode
	 */
	public boolean isValid(int row, int col, int[] sol) {
		for (int i = 0; i < row; i++) {
			if (col == sol[i])
				return false;

			if (row - i == Math.abs(sol[i] - col))
				return false;
		}

		return true;
	}

	public void place(int row, int n, int[] sol, ArrayList<String[]> res) {
		if (row == n) {
			// compose a new solution
			String[] item = new String[n];
			char[] chars = new char[n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(chars, '.');
				chars[sol[i]] = 'Q';
				item[i] = new String(chars);
			}
			res.add(item);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(row, i, sol)) {
				sol[row] = i;
				place(row + 1, n, sol, res);
			}
		}

	}

	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> res = new ArrayList<String[]>();
		int[] sol = new int[n];
		place(0, n, sol, res);

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlaceQueens pq = new PlaceQueens();
		//System.out.println(pq.solveNQueens(4));
		for (String[] item : pq.solveNQueens(9)) {
			for (int i = 0; i < item.length; i++) {
				System.out.println("[" + item[i] + "]");
			}
			System.out.println();
		}
	}

}
