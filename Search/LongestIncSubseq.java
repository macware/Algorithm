package Search;

import java.util.*;

public class LongestIncSubseq {

	public static ArrayList<Integer> finding(int[] arr) {
		ArrayList<Integer> result = null;
		ArrayList<Integer> newResult;

		newResult = new ArrayList<Integer>();
		newResult.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= arr[i - 1]) {
				newResult.add(arr[i]);
			} else {
				if (result == null || result.size() < newResult.size()) {
					result = newResult;
				}
				newResult = new ArrayList<Integer>();
				newResult.add(arr[i]);
			}
		}
		
		if (result == null || result.size() < newResult.size())
			result = newResult;

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 13, 14, 10, 11, 12 };
		System.out.println(finding(a));
	}

}
