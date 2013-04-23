package Math;

import java.util.ArrayList;

public class PermutSeq {

	/*
	 * for n=4, k=20, it has 19 permutations before, 19 = 3*3! + 0*2! + 1*1! + 0
	 */
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n <= 0 || k <= 0) {
			return null;
		}

		StringBuilder res = new StringBuilder();
		ArrayList<Integer> num = new ArrayList<Integer>();
		int d, i;
		d = 1;
		for (i = 1; i <= n; i++) {
			num.add(i);
			d *= i;
		}

		if (k > d)
			return null;

		int idx;
		for (i = n; i >= 1; i--) {
			d /= i;
			idx = (k - 1) / d;
			k -= idx * d;
			res.append(num.get(idx));
			num.remove(idx);
		}

		return res.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
