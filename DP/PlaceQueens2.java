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

	public void placing(int row, int ld, int rd, int[] refs) {
		if (row == refs[0]) {
			refs[1]++;
			return;
		}

		int p, pos = refs[0] & (~(row | ld | rd));
		while (pos != 0) {
			p = pos & (~(pos - 1)); // p = pos & (-pos); ~(pos-1) = -(pos-1)-1
			// ld: p at this level, cant put p-1 at next level, so forth p-2,
			// p-3,
			// rd: p at this level, cant put p+1 at next level, so forth p+2,
			// p+3,
			placing(row | p, (ld | p) >> 1, (rd | p) << 1, refs);
			pos = pos & (pos - 1);
		}
	}

	public int totalNQueens3(int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (n <= 0)
			return 0;
		int[] refs = new int[2];
		refs[0] = (1 << n) - 1;
		refs[1] = 0;
		placing(0, 0, 0, refs);

		return refs[1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
