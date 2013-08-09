package List;

import java.util.*;

public class ThreeSum {

	/**
	 * one side moving doesn't need duplicate checking, just the same as before
	 * 
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		for (int k = 0; k < num.length - 2; k++) {
			if (k != 0 && num[k] == num[k - 1])
				continue;

			int i = k + 1;
			int j = num.length - 1;

			while (i < j) {
				int rem = num[i] + num[j] + num[k];
				if (0 == rem) {
					// find one
					ArrayList<Integer> item = new ArrayList<Integer>();
					item.add(num[k]);
					item.add(num[i]);
					item.add(num[j]);
					res.add(item);

					do {
						i++;
					} while (i < j && num[i] == num[i - 1]);
					do {
						j--;
					} while (i < j && num[j] == num[j + 1]);
				} else if (rem > 0)
					j--;
				else
					i++;
			}
		}

		return res;
	}
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num, int start, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		for (int k = start; k < num.length - 2; k++) {
			if (k > start && num[k] == num[k - 1])
				continue;

			int i = k + 1;
			int j = num.length - 1;

			while (i < j) {
				int rem = num[i] + num[j] + num[k];
				if (target == rem) {
					// find one
					ArrayList<Integer> item = new ArrayList<Integer>();
					item.add(num[k]);
					item.add(num[i]);
					item.add(num[j]);
					res.add(item);

					do {
						i++;
					} while (i < j && num[i] == num[i - 1]);
					do {
						j--;
					} while (i < j && num[j] == num[j + 1]);
				} else if (rem > target)
					j--;
				else
					i++;
			}
		}

		return res;
	}

	/**
	 * choose the current result!
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int sum = Integer.MAX_VALUE;
		Arrays.sort(num);

		for (int k = 0; k < num.length - 2; k++) {
			if (k > 0 && num[k] == num[k - 1])
				continue;

			int i = k + 1;
			int j = num.length - 1;
			while (i < j) {
				int res = num[k] + num[i] + num[j];
				if (Math.abs(sum - target) > Math.abs(res - target))
					sum = res;

				if (res == target)
					return sum;

				else if (res > target) {
					do {
						j--;
					} while (i < j && num[j] == num[j + 1]);
				} else {
					do {
						i++;
					} while (i < j && num[i] == num[i - 1]);
				}
			}
		}

		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum ts = new ThreeSum();
		System.out.println(ts.threeSumClosest(new int[] { 4, 0, 5, -5, 3, 3, 0,
				-4, -5 }, -2));
	}

}
