package Math;

import java.util.Arrays;

public class NextPermut {

	private void getCloserDecPair_recur(int[] num, int start, int end, DecPair dpair) {
		if (start >= end)
			return;

		int i;
		for (i = end - 1; i >= start; i--)
			if (num[i] < num[end]) {
				dpair.i = i;
				dpair.j = end;
				break;
			}

		getCloserDecPair_recur(num, i + 1, end - 1, dpair);
	}

	public class DecPair {
		public int i;
		public int j;

		public DecPair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private void getCloserDecPair(int[] num, DecPair dpair) {

		int start = 0;
		int end = num.length - 1;

		int i;
		while (start < end) {
			for (i = end - 1; i >= start; i--)
				if (num[i] < num[end]) {
					dpair.i = i;
					dpair.j = end;
					break;
				}
			
			start = i+1;
			end = end-1;
		}
	}

	public void nextPermutation(int[] num) {
		if (num == null || num.length < 2)
			return;
		DecPair dpair = new DecPair(-1, -1);
		getCloserDecPair(num, dpair);
		if (dpair.i != -1) {
			int tmp = num[dpair.i];
			num[dpair.i] = num[dpair.j];
			num[dpair.j] = tmp;
			
		}
		Arrays.sort(num, dpair.i + 1, num.length);
	}

	/*
	 * NextPermutation. This is similar to the problem of career cup 5.3, which
	 * cares about binary format, but here, we concentrates on decimal format.
	 * However, the idea are the same: Flip and then rearrange numbers that
	 * followed. Here 0 means a decreasing point, 1 means keep increasing.
	 */
	public void nextPermutation_unclear(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (num == null || num.length < 2) {
			return;
		}

		int i, j;
		for (i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				for (j = num.length - 1; j >= i + 1; j--) {
					if (num[j] > num[i]) {
						int temp = num[j];
						num[j] = num[i];
						num[i] = temp;

						Arrays.sort(num, i + 1, num.length);
						return;
					}
				}
			}
		}

		return;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
