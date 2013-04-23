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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
