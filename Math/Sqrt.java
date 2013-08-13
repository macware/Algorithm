package Math;

public class Sqrt {

	public int sqrt_binary(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 2)
			return x;

		int low = 0, high = x;
		int mid, div;

		while (high - low > 1) {
			mid = (low + high) / 2;
			div = x / mid;
			if (mid == div)
				return mid;

			if (div > mid)
				low = mid;
			else
				high = mid;
		}

		return low;
	}

	public int sqrt_newton(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 2)
			return x;

		int digits = 0;
		int origin = x;
		while (origin > 0) {
			origin >>= 1;
			digits++;
		}

		double r1 = 1.0 * (1 << (digits / 2));
		double r0 = 0;

		while (Math.abs(r1 - r0) > 0.01) {
			r0 = r1;
			r1 = (r0 + x / r0) / 2;
		}

		return (int) r1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt sq = new Sqrt();
		System.out.println(sq.sqrt_newton(1117460177));
	}

}
