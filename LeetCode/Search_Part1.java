package LeetCode;

import java.util.*;

import List.*;

public class Search_Part1 {

	/*
	 * Three Sum. If the brute force way takes more than 2 iteration, it might
	 * be helpful to sort the input before explorations, which is also helpful
	 * to remove duplicates. Think about why it is safe to remove the operated
	 * item, assuring that we no longer need it in further exploration.
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3)
			return result;

		ArrayList<Integer> newResult;

		Arrays.sort(num);

		int i, start, end, sum, res;
		for (i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;

			sum = 0 - num[i];
			start = i + 1;
			end = num.length - 1;
			while (start < end) {
				res = num[start] + num[end] - sum;
				if (res > 0) {
					end--;
				} else if (res < 0) {
					start++;
				} else {
					newResult = new ArrayList<Integer>();
					newResult.add(num[i]);
					newResult.add(num[start]);
					newResult.add(num[end]);

					result.add(newResult);

					do {
						start++;
					} while (start < end && num[start] == num[start - 1]);
					do {
						end--;
					} while (start < end && num[end] == num[end + 1]);
				}
			}
		}

		return result;
	}

	/*
	 * Permutation sequence
	 */

	/*
	 * 4,1,4,2,2,2,0 4,2,0,2,3,2,0 4,2,2,0,0,2,3 4,2,0,3,0,2,2
	 */
	/*
	 * NextPermutation. This is similar to the problem of career cup 5.3, which
	 * cares about binary format, but here, we concentrates on decimal format.
	 * However, the idea are the same: Flip and then rearrange numbers that
	 * followed. Here 0 means a decreasing point, 1 means keep increasing.
	 */
	public class DecPair {
		public int i;
		public int j;

		public DecPair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	private void getCloserDecPair(int[] num, int start, int end, DecPair dpair) {
		if (start >= end)
			return;

		int i;
		for (i = end - 1; i >= start; i--)
			if (num[i] < num[end]) {
				dpair.i = i;
				dpair.j = end;
				break;
			}

		getCloserDecPair(num, i + 1, end - 1, dpair);
	}

	public void nextPermutation(int[] num) {
		if (num == null || num.length < 2)
			return;
		DecPair dpair = new DecPair(-1, -1);
		getCloserDecPair(num, 0, num.length-1, dpair);
		if (dpair.i == -1){
			Arrays.sort(num);
		} else {
			int tmp = num[dpair.i];
			num[dpair.i] = num[dpair.j];
			num[dpair.j] = tmp;
			Arrays.sort(num, dpair.i + 1, num.length);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_Part1 oj = new Search_Part1();
		int[] num = new int[] { 4,2,0,2,3,2,0 };
		oj.nextPermutation(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}

	}

}
