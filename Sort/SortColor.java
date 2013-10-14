package Sort;

public class SortColor {

	/*
	 * Could use count sort to solve the problem. Count sort is helpful in case
	 * that there are only limited kinds of elements.
	 */
	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length < 2)
			return;

		// The territory technique
		int i, j, k;
		i = -1;
		k = A.length;
		j = 0;

		// The swap technique
		while (true) {
			if (j == i || A[j] == 1) {
				j++;
			}

			if (j >= k)
				break;

			if (A[j] == 0) {
				i++;
				A[j] = A[i];
				A[i] = 0;
			}

			if (A[j] == 2) {
				k--;
				A[j] = A[k];
				A[k] = 2;
			}
		}
	}

	public void sortColors2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return;

		int i = -1, j = A.length, k = 0;

		while (k < j) {

			if (A[k] == 0) {
				A[k] = A[++i];
				A[i] = 0;
			}

			if (A[k] == 2) {
				A[k] = A[--j];
				A[j] = 2;
			}

			if (i == k || A[k] == 1)
				k++;
		}
	}

	public void sortColors3(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return;

		int[] counter = new int[3];
		int i;

		for (i = 0; i < A.length; i++)
			counter[A[i]]++;

		int k = 0;
		for (i = 0; i < 3; i++) {
			while (counter[i] > 0) {
				A[k++] = i;
				counter[i]--;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
