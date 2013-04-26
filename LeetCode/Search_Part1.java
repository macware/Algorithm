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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
