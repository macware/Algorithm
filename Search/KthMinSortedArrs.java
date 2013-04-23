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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] { 11, 12, 13, 14, 17 };
		int[] B = new int[] { 5, 6, 8, 9 };

		KthMinSortedArrs kth = new KthMinSortedArrs();
		System.out.println(kth.findKthSmallest(A, B, 8));
	}

}
