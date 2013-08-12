package DP;

import java.util.*;

public class PlaceQueens2 {

	int cnt;

	public boolean isValid(int row, int col, int[] sol) {
		for (int i = 0; i < row; i++) {
			if (sol[i] == col)
				return false;

			if (row - i == Math.abs(sol[i] - col))
				return false;
		}

		return true;
	}

	public void place(int row, int[] sol) {
		if (row == sol.length) {
			cnt++;
			return;
		}

		for (int i = 0; i < sol.length; i++) {
			if (isValid(row, i, sol)) {
				sol[row] = i;
				place(row + 1, sol);
			}
		}
	}

	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0)
			return 0;

		int[] sol = new int[n];
		Arrays.fill(sol, -1);
		cnt = 0;
		place(0, sol);

		return cnt;
	}

	/**
	 * Bit magic: row indicates invalid columns, ld indicates the invalid
	 * left-diagonal, rd indicates the invalid right-diagonal. -pos means (not
	 * pos + 1), which flips the first 0 in (not pos) to be 1, thus get the
	 * first 1 of pos. After choosing column p in this row, its affect on the ld
	 * should << 1, and >> 1 on the rd (Think about how the diagonal grows).
	 * 
	 */
	public int all;

	public void place2(int row, int ld, int rd) {
		if (row == all) {
			cnt++;
			return;
		}

		int pos, p;
		pos = all & (~(row | ld | rd));
		while (pos != 0) {
			p = pos & (-pos);
			pos = pos - p;
			place2(row | p, (ld | p) << 1, (rd | p) >> 1);
		}
	}

	public int totalNQueens2(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0)
			return 0;

		cnt = 0;
		all = (1 << n) - 1;
		place2(0, 0, 0);

		return cnt;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
