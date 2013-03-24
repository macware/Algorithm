package LeetCode;

import java.util.*;

import List.*;

public class SearchPart1 {
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

	public class Part implements Comparable<Part> {
		public int start;
		public int end;

		public Part(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Part p) {
			// TODO Auto-generated method stub
			if (start < p.start)
				return -1;
			else if (start > p.start)
				return 1;

			return 0;
		}
	}

	public void testPart() {
		ArrayList<Part> partList = new ArrayList<Part>();
		partList.add(new Part(8, 10));
		partList.add(new Part(1, 3));
		partList.add(new Part(15, 18));
		partList.add(new Part(2, 6));

		Collections.sort(partList);

		for (Part p : partList)
			System.out.println("[" + p.start + "," + p.end + "]");
	}

	/*
	 * This is the right version of max sum!
	 */
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (max < sum) {
				max = sum;
			}

			if (sum < 0) {
				sum = 0;
			}
		}

		return max;
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
     * 
     */
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (height == null || height.length == 0)
			return 0;

		if (height.length == 1)
			return height[0];

		Stack<Integer> ints = new Stack<Integer>();
		ints.push(height[0]);

		int j = 1;
		int max = 0;

		while (j < height.length) {
			if (height[j] >= ints.peek()) {
				ints.push(height[j]);
				j++;
			} else {
				int count = 1;
				while (ints.size() > 0 && ints.peek() > height[j]) {
					max = Math.max(max, ints.pop() * count);
					count++;
				}

				for (int i = 0; i < count; i++) {
					ints.push(height[j]);
				}
				j++;
			}
		}

		if (ints.size() > 0) {
			int count = 1;
			while (ints.size() > 0) {
				max = Math.max(max, ints.pop() * count);
				count++;
			}
		}

		return max;
	}

	/*
	 * Permutation sequence
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

	/*
	 * 4,1,4,2,2,2,0 4,2,0,2,3,2,0 4,2,2,0,0,2,3 4,2,0,3,0,2,2
	 */
	/*
	 * NextPermutation. This is similar to the problem of career cup 5.3, which
	 * cares about binary format, but here, we concentrates on decimal format.
	 * However, the idea are the same: Flip and then rearrange numbers that
	 * followed. Here 0 means a decreasing point, 1 means keep increasing.
	 */
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (num == null || num.length < 2) {
			return;
		}

		int i, j;
		for (i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				for (j = num.length - 1; j >= i+1; j--) {
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
		SearchPart1 oj = new SearchPart1();
		int[] num = new int[]{1,2,3,4,5};
		oj.nextPermutation(num);
		for (int i = 0; i < num.length; i++){
			System.out.print(num[i]);
		}

	}

}
