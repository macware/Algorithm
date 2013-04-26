package Tree;

public class UniqueBSTs {

	/*
	 * Similar to fib array. f(n) = sum(i=1..n)(f(i-1)*f(n-i)); f(0) = f(1) = 1;
	 */
	public int numTreesHelper(int n, int[] cache) {
		if (n <= 1)
			return 1;
		if (cache[n] != 0)
			return cache[n];

		int ret = 0;
		for (int i = 1; i <= n; i++) {
			ret += numTreesHelper(i - 1, cache) * numTreesHelper(n - i, cache);
		}

		cache[n] = ret;
		return ret;
	}

	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 0)
			return 0;

		if (n <= 1)
			return 1;

		int[] cache = new int[n + 1];
		return numTreesHelper(n, cache);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
