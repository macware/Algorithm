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

			// be conservative
			if (div > mid)
				low = mid;
			else
				high = mid;
		}

		return low;
	}

	public int sqrt_overflow(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0)
			return -1;

		int low = 0, high = x, mid, tmp;
		while (low < high) {
			mid = (low + high) / 2;
			tmp = mid * mid;
			if (x == tmp)
				return mid;

			if (x > tmp)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return low;
	}

	public int sqrt_newton_simple(int x) {
		if (x <= 1)
			return x;

		double x1 = 0, x2 = x / 2;
		while (Math.abs(x2 - x1) > 0.01) {
			x1 = x2;
			x2 = 0.5 * (x1 + x / x1);
		}

		return (int) x2;
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

	public int fib(int n) {
		if (n <= 0)
			return 0;

		int f0 = 0, f1 = 1, f2;
		for (int i = 2; i <= n; i++) {
			f2 = f1 + f0;
			f0 = f1;
			f1 = f2;
			System.out.print(f1 + " ");
		}

		return f1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt sq = new Sqrt();
		System.out.println(sq.fib(10));
	}

}
