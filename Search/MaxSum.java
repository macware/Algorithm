package Search;

public class MaxSum {

	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int sum = 0;

		int start, end, newStart;

		start = end = -1;
		newStart = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (max < sum) {
				max = sum;
				start = newStart;
				end = i;
			}

			if (sum < 0) {
				sum = 0;
				newStart = i + 1;
			}
		}

		if (start == -1)
			start = newStart;
		
		System.out.println("The sub array starts from " + start + " to " + end);

		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSum msum = new MaxSum();
		System.out.println(msum.maxSubArray(new int[]{2,3,-8,-1,2,4,-2,3,-1,-3,2}));
	}

}
