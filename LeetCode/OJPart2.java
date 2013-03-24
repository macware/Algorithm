package LeetCode;

import java.util.*;

public class OJPart2 {

	/*
	 * Reverse digits of an integer. If the integer's last digit is 0, what
	 * should the output be? Did you notice that the reversed integer might
	 * overflow? How to reverse? Remember no assumption (the integer might be
	 * negative) and (%10,/10) operation pair to peel off each digit of an
	 * [positive] integer The very efficient Qinjiu-Shao Algorithm
	 */
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int res = 0;
		int val = x;
		boolean isNeg = x > 0 ? false : true;

		if (isNeg)
			val = Math.abs(val);

		while (val != 0) {
			res = res * 10 + val % 10;
			val = val / 10;
		}

		// Overflow
		if (res < 0)
			return -1;

		if (isNeg)
			res *= -1;

		return res;
	}

	/*
	 * Regular expression matching. Don't be rush to write codes. Think the
	 * solution in high level throughly and make it as clear,simple as possible.
	 * Especially for recursion or DP problems, think how the problem evolves as
	 * the input increases by one. Char manipulation using string is really
	 * buggy. Check 0 length before you visit and remember that substring is
	 * inclusive.
	 */
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p.equals("") && s.equals(""))
			return true;

		if (p.length() > 1) {
			if (p.charAt(1) != '*') {
				if (s.length() == 0)
					return false;

				if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
					return isMatch(s.substring(1), p.substring(1));
				}
			} else {
				int i = 0;
				for (i = 0; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.') {
						if (isMatch(s.substring(i), p.substring(2)))
							return true;
					} else
						break;
				}

				// make sure we include the case s.substring(s.length());
				return isMatch(s.substring(i), p.substring(2));
			}
		} else {
			if (s.length() == 0 || p.length() == 0)
				return false;

			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
				return isMatch(s.substring(1), p.substring(1));
		}

		return false;
	}

	/*
	 * Find kth smallest in two sorted array in log time. Cutting an array in
	 * the middle and getting its length in java is not as handy as in c. In
	 * java, cutting is usually done by specifying a from index (inclusive) and
	 * to index (exclusive). Pay attention to the edge cases (index = 0 or
	 * length). To make your codes understandable, use more local descriptive
	 * variables if necessary.
	 */
	double findKthSmallest(int[] A, int Alen, int[] B, int Blen, int k,
			boolean isMeven) {
		int i = (int) ((double) Alen / (Alen + Blen) * (k - 1));
		int j = k - 1 - i;

		int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i - 1]);
		int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j - 1]);
		int Ai = ((i == Alen) ? Integer.MAX_VALUE : A[i]);
		int Bj = ((j == Blen) ? Integer.MAX_VALUE : B[j]);

		if (Bj_1 < Ai && Ai <= Bj) {
			if (isMeven) {
				if (i != Alen - 1 && A[i + 1] < Bj)
					Bj = A[i + 1];
				return (Ai + Bj) * 1.0 / 2;
			} else
				return Ai;

		} else if (Ai_1 < Bj && Bj <= Ai) {
			if (isMeven) {
				if (j != Blen - 1 && B[j + 1] < Ai)
					Ai = B[j + 1];
				return (Ai + Bj) * 1.0 / 2;
			} else
				return Bj;
		}

		int[] newA;
		int[] newB;
		int newAlen, newBlen;
		newAlen = newBlen = 0;
		if (Ai < Bj) {
			if (i + 1 > Alen) {
				newA = null;
				newAlen = 0;
			} else {
				newA = Arrays.copyOfRange(A, i + 1, Alen);
				newAlen = newA.length;
			}

			if (j - 1 < 0) {
				newB = null;
				newBlen = 0;
			} else {
				newB = Arrays.copyOfRange(B, 0, j);
				newBlen = newB.length;
			}

			return findKthSmallest(newA, newAlen, newB, newBlen, k - i - 1,
					isMeven);

		} else {
			if (j + 1 > Blen) {
				newB = null;
				newBlen = 0;
			} else {
				newB = Arrays.copyOfRange(B, j + 1, Blen);
				newBlen = newB.length;
			}

			if (i - 1 < 0) {
				newA = null;
				newAlen = 0;
			} else {
				newA = Arrays.copyOfRange(A, 0, i);
				newAlen = newA.length;
			}

			return findKthSmallest(newA, newAlen, newB, newBlen, k - j - 1,
					isMeven);
		}
	}

	double findKthSmallestSpec(int[] A, int Aoff, int Alen, int[] B, int Boff,
			int Blen, int k, boolean isMeven) {
		int di = (int) ((double) Alen / (Alen + Blen) * (k - 1));
		int dj = k - 1 - di;

		int i = di + Aoff;
		int j = dj + Boff;

		int Ai_1 = ((di == 0) ? Integer.MIN_VALUE : A[i - 1]);
		int Bj_1 = ((dj == 0) ? Integer.MIN_VALUE : B[j - 1]);
		int Ai = ((di == Alen) ? Integer.MAX_VALUE : A[i]);
		int Bj = ((dj == Blen) ? Integer.MAX_VALUE : B[j]);

		if (Bj_1 < Ai && Ai <= Bj) {
			if (isMeven) {
				if (di != Alen - 1 && A[i + 1] < Bj)
					Bj = A[i + 1];
				return (Ai + Bj) * 1.0 / 2;
			} else
				return Ai;

		} else if (Ai_1 < Bj && Bj <= Ai) {
			if (isMeven) {
				if (dj != Blen - 1 && B[j + 1] < Ai)
					Ai = B[j + 1];
				return (Ai + Bj) * 1.0 / 2;
			} else
				return Bj;
		}

		if (Ai < Bj) {
			return findKthSmallestSpec(A, i + 1, Alen - di - 1, B, Boff, dj, k
					- di - 1, isMeven);
		} else {
			return findKthSmallestSpec(A, Aoff, di, B, j + 1, Blen - dj - 1, k
					- dj - 1, isMeven);
		}
	}

	public class IntWrapper {
		public int val;

		public IntWrapper(int v) {
			val = v;
		}
	}

	public boolean checking(int x, IntWrapper wrap) {
		if (x == 0)
			return true;

		if (checking(x / 10, wrap) && (x % 10 == wrap.val % 10)) {
			wrap.val = wrap.val / 10;
			return true;
		} else
			return false;
	}

	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0)
			return false;

		if (x < 10)
			return true;

		IntWrapper wrap = new IntWrapper(x);

		return checking(x, wrap);
	}

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
	 * Longest Common Prefix. Some times it's not that easy to come up with a
	 * brute force way. The key idea is: think the problem in a natural way, as
	 * straight forward as possible.
	 */
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (strs == null || strs.length == 0 || strs[0].equals(""))
			return "";
		if (strs.length == 1)
			return strs[0];

		int i, j;

		for (j = 0; j < strs[0].length(); j++) {
			for (i = 1; i < strs.length; i++) {
				if (strs[i].length() <= j
						|| strs[i].charAt(j) != strs[0].charAt(j)) {
					System.out.println("j = "+j);
					return strs[0].substring(0, j);
				}
			}
		}

		System.out.println("j = "+j);
		return strs[0].substring(0, j);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OJPart2 oj = new OJPart2();
		System.out.println(oj.longestCommonPrefix(new String[]{"","aaa"}));
	}

}
