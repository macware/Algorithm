package Search;

import java.util.Arrays;

public class KthMinSortedArrs {

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

	double findMedian(int[] A, int as, int ae, int[] B, int bs, int be, int k,
			boolean isEven) {
		int alen = ae - as + 1;
		int blen = be - bs + 1;

		int ai = (int) ((double) alen / (alen + blen) * (k - 1));
		int bj = k - 1 - ai;

		int Ai_1 = (ai == 0) ? Integer.MIN_VALUE : A[as + ai - 1];
		int Bj_1 = (bj == 0) ? Integer.MIN_VALUE : B[bs + bj - 1];
		int Ai = (ai == alen) ? Integer.MAX_VALUE : A[as + ai];
		int Bj = (bj == blen) ? Integer.MAX_VALUE : B[bs + bj];

		if (Ai >= Bj_1 && Ai <= Bj) {
			if (isEven) {
				if (ai != alen - 1 && A[as + ai + 1] < Bj)
					Bj = A[as + ai + 1];
				return (Ai + Bj) * 1.0 / 2;
			}
			return Ai;
		} else if (Bj >= Ai_1 && Bj <= Ai) {
			if (isEven) {
				if (bj != blen - 1 && B[bs + bj + 1] < Ai)
					Ai = B[bs + bj + 1];
				return (Ai + Bj) * 1.0 / 2;
			}
			return Bj;
		}

		if (Ai < Bj) {
			return findMedian(A, as + ai + 1, ae, B, bs, be - bj - 1, k - ai
					- 1, isEven);
		} else
			return findMedian(A, as, ae - ai - 1, B, bs + bj + 1, be, k - bj
					- 1, isEven);
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int k = A.length + B.length;

		if (k % 2 == 0)
			return findMedian(A, 0, A.length - 1, B, 0, B.length - 1, k / 2,
					true);
		else {
			return findMedian(A, 0, A.length - 1, B, 0, B.length - 1,
					k / 2 + 1, false);
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
				if (i != A.length - 1 && A[i + 1] < Bj)
					Bj = A[i + 1];
				return (Ai + Bj) * 1.0 / 2;
			} else
				return Ai;

		} else if (Ai_1 < Bj && Bj <= Ai) {
			if (isMeven) {
				if (j != B.length - 1 && B[j + 1] < Ai)
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

	public boolean even;

	public double medianFinder(int[] A, int as, int ae, int[] B, int bs,
			int be, int k) {
		int alen = 0, blen = 0;
		if (as <= ae)
			alen = ae - as + 1;
		if (bs <= be)
			blen = be - bs + 1;

		int i = alen * (k - 1) / (alen + blen);
		int j = k - 1 - i;

		int ai_1, ai, bj_1, bj;

		ai_1 = (i == 0 ? Integer.MIN_VALUE : A[as + i - 1]);
		ai = (i == alen ? Integer.MAX_VALUE : A[as + i]);
		bj_1 = (j == 0 ? Integer.MIN_VALUE : B[bs + j - 1]);
		bj = (j == blen ? Integer.MAX_VALUE : B[bs + j]);

		if (ai >= bj_1 && ai <= bj) {
			if (even) {
				i = as + i;
				if (i != A.length - 1 && A[i + 1] < bj)
					bj = A[i + 1];
				return (ai + bj) * 0.5;
			}
			return ai;
		} else if (bj >= ai_1 && bj <= ai) {
			if (even) {
				j = bs + j;
				if (j != B.length - 1 && B[j + 1] < ai)
					ai = B[j + 1];
				return (ai + bj) * 0.5;
			}
			return bj;
		} else {
			if (ai < bj)
				return medianFinder(A, as + i + 1, ae, B, bs, bs + j, k - i - 1);
			else
				return medianFinder(A, as, as + i, B, bs + j + 1, be, k - j - 1);
		}
	}

	public double findMedianSortedArrays3(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int k = A.length + B.length;
		if (k == 0)
			return 0;

		if (k > 1) {
			even = (k % 2 == 0);
			k /= 2;
			if (!even)
				k += 1;
		}

		return medianFinder(A, 0, A.length - 1, B, 0, B.length - 1, k);
	}

	/* implementation in c is much more convenient */
	// int findKthSmallest(int A[], int m, int B[], int n, int k) {
	// assert(m >= 0); assert(n >= 0); assert(k > 0); assert(k <= m+n);
	//
	// int i = (int)((double)m / (m+n) * (k-1));
	// int j = (k-1) - i;
	//
	// assert(i >= 0); assert(j >= 0); assert(i <= m); assert(j <= n);
	// // invariant: i + j = k-1
	// // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
	// int Ai_1 = ((i == 0) ? INT_MIN : A[i-1]);
	// int Bj_1 = ((j == 0) ? INT_MIN : B[j-1]);
	// int Ai = ((i == m) ? INT_MAX : A[i]);
	// int Bj = ((j == n) ? INT_MAX : B[j]);
	//
	// if (Bj_1 < Ai && Ai < Bj)
	// return Ai;
	// else if (Ai_1 < Bj && Bj < Ai)
	// return Bj;
	//
	// assert((Ai > Bj && Ai_1 > Bj) ||
	// (Ai < Bj && Ai < Bj_1));
	//
	// // if none of the cases above, then it is either:
	// if (Ai < Bj)
	// // exclude Ai and below portion
	// // exclude Bj and above portion
	// return findKthSmallest(A+i+1, m-i-1, B, j, k-i-1);
	// else // Bj < Ai
	// // exclude Ai and above portion
	// // exclude Bj and below portion
	// return findKthSmallest(A, i, B+j+1, n-j-1, k-j-1);
	// }

	public double findMedianSortedArrays2(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || B == null)
			return 0;

		int size = A.length + B.length;
		boolean even = (size % 2 == 0);

		size /= 2;
		if (!even)
			size += 1;

		int k = 1, i = 0, j = 0;
		double res = 0.0;
		while (i < A.length && j < B.length) {
			if (k >= size) {
				if (k == size)
					res += Math.min(A[i], B[j]);
				else if (even) {
					res += Math.min(A[i], B[j]);
					return res / 2;
				} else
					break;
			}

			if (A[i] < B[j])
				i++;
			else
				j++;

			k++;
		}

		while (i < A.length) {
			if (k >= size) {
				if (k == size)
					res += A[i];
				else if (even) {
					res += A[i];
					return res / 2;
				} else
					break;
			}

			i++;
			k++;
		}

		while (j < B.length) {
			if (k >= size) {
				if (k == size)
					res += B[j];
				else if (even) {
					res += B[j];
					return res / 2;
				} else
					break;
			}

			j++;
			k++;
		}

		return res;
	}

	public int findKthSmallest(int[] A, int[] B, int k) {
		int n = 0;
		int i, j;

		if (k > A.length + B.length)
			return -1;

		i = j = 0;
		while (i < A.length && j < B.length) {
			if (n == k - 1) {
				return Math.min(A[i], B[j]);
			}

			if (A[i] >= B[j])
				j++;
			else
				i++;
			n++;
		}

		while (i < A.length) {
			if (n == k - 1)
				return A[i];
			i++;
			n++;
		}

		while (j < B.length) {
			if (n == k - 1)
				return B[j];
			j++;
			n++;
		}

		return -1;
	}

	public double findMedianSortedArrays_On(int A[], int B[]) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int Alen = 0, Blen = 0;
		if (A != null)
			Alen = A.length;
		if (B != null)
			Blen = B.length;

		int k = Alen + Blen;
		if (k == 0)
			return 0;

		int i = 0, j = 0, n = 0, t = 0;
		boolean isOdd = (k % 2 == 1);
		k /= 2;

		while (n < k && i < Alen && j < Blen) {
			if (A[i] > B[j])
				t = B[j++];
			else
				t = A[i++];
			n++;
		}

		while (n < k && i < Alen) {
			t = A[i++];
			n++;
		}

		while (n < k && j < Blen) {
			t = B[j++];
			n++;
		}

		int next = Integer.MAX_VALUE;
		if (i != Alen)
			next = A[i];
		if (j != Blen && next > B[j])
			next = B[j];

		if (isOdd)
			return next;

		return 1.0 * (t + next) / 2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] {};
		int[] B = new int[] { 1, 2, 3, 4, 5 };

		KthMinSortedArrs kth = new KthMinSortedArrs();
		int k = A.length + B.length;
		if (k > 1) {
			kth.even = (k % 2 == 0);
			k /= 2;
		}
		double res2 = 0.0, res = 0.0;

		res = kth.medianFinder(A, 0, A.length - 1, B, 0, B.length - 1, k);
		// res2 = kth.findKthSmallestSpec(A, 0, A.length, B, 0, B.length, 2,
		// kth.even);
		System.out.println(res + " == " + res2);
	}

}
