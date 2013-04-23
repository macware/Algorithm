public class Twitter {

	public static int binary_gap_old(int N) {
		if (N <= 0)
			return 0;

		int maxGap, newGap;
		maxGap = 0;
		/* newGap = 0 means we passed all the trailing zeroes */
		newGap = -1;

		int b, n = N;
		while (n > 0) {
			b = n & 1;
			if (b == 1) {
				if (newGap > 0 && newGap > maxGap) {
					maxGap = newGap;
					newGap = 0;
				} else if (newGap == -1)
					newGap = 0;
			} else {
				if (newGap != -1)
					newGap++;
			}
			n = n >> 1;
		}

		return maxGap;
	}

	public static int binary_gap(int N) {
		if (N <= 0)
			return 0;

		int maxGap, newGap;
		maxGap = 0;
		/* newGap = 0 means we passed all the trailing zeroes */
		newGap = -1;

		int b, n = N;
		while (n > 0) {
			b = n & 1;
			if (b == 1) {
				if (newGap > maxGap)
					maxGap = newGap;
				newGap = 0;
			} else {
				if (newGap != -1)
					newGap++;
			}
			n = n >> 1;
		}

		return maxGap;
	}

	public static int unvisited(int[] A) {
		if (A == null || A.length == 0)
			return 0;

		int[] record = new int[A.length];
		int idx = 0;

		record[0] = 1;
		while (true) {
			idx = idx + A[idx];
			if (idx >= A.length || idx < 0)
				break;
			if (record[idx] == 1)
				break;
			record[idx] = 1;
		}

		int res = 0;
		for (int i = 0; i < record.length; i++) {
			if (record[i] == 0)
				res++;
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(binary_gap(7));
		System.out.println(binary_gap_old(10921));
	}

}
