package Search;

public class TrapWater {

	/**
	 * max: I know there exists a highest bar. Before I meet it, I can contain h
	 * - A[i] water if A[i] is smaller than h. If A[i] is larger than h, I can
	 * potentially contain more water.
	 * @param A
	 * @return
	 */
	public int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0, h = 0, water = 0;
		int i;
		for (i = 0; i < A.length; i++)
			if (A[i] > A[max])
				max = i;

		for (i = 0; i < max; i++)
			if (h > A[i])
				water += h - A[i];
			else
				h = A[i];

		h = 0;
		for (i = A.length - 1; i > max; i--)
			if (h > A[i])
				water += h - A[i];
			else
				h = A[i];

		return water;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
