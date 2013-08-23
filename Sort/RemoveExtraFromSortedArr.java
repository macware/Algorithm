package Sort;

public class RemoveExtraFromSortedArr {

	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return 0;

		if (A.length < 3)
			return A.length;

		int i = -1, tag = 0, count = 1, cur = 1;
		while (cur < A.length) {
			if (A[cur] == A[tag])
				count++;
			else {
				A[++i] = A[tag];
				if (count > 1)
					A[++i] = A[tag + 1];

				count = 1;
				tag = cur;
			}

			if (count == 3) {
				A[++i] = A[tag];
				A[++i] = A[tag + 1];

				while (cur < A.length && A[cur] == A[tag])
					cur++;
				tag = cur;
				count = 1;
			}

			cur++;
		}

		while (tag < A.length)
			A[++i] = A[tag++];

		return (i + 1);
	}

	public int removeDuplicates2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return 0;

		if (A.length < 3)
			return A.length;

		int i = -1, tag = 0, count = 1, cur = 1;
		while (cur < A.length) {
			if (A[cur] == A[tag])
				count++;

			if (A[cur] != A[tag] || count == 3) {
				A[++i] = A[tag];
				if (count > 1)
					A[++i] = A[tag + 1];

				while (cur < A.length && A[cur] == A[tag])
					cur++;
				tag = cur;
				count = 1;
			}

			cur++;
		}

		while (tag < A.length)
			A[++i] = A[tag++];

		return (i + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
