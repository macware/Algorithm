package LeetCode;

public class NumberPart1 {

	/*
	 * Reverse digits of an integer. If the integer's last digit is 0, what
	 * should the output be? Did you notice that the reversed integer might
	 * overflow? How to reverse? Remember no assumption (the integer might be
	 * negative) and (%10,/10) operation pair to peel off each digit of an
	 * [positive] integer The very efficient Qinjiu-Shao Algorithm
	 */
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int res = 0;
		int val = x;
		boolean isNeg = x > 0 ? false : true;

		if (isNeg)
			val = Math.abs(val);

		while (val != 0) {
			res = res * 10 + val % 10;
			val = val / 10;
		}

		// Overflow
		if (res < 0)
			return -1;

		if (isNeg)
			res *= -1;

		return res;
	}
	

	public class IntWrapper {
		public int val;

		public IntWrapper(int v) {
			val = v;
		}
	}

	public boolean checking(int x, IntWrapper wrap) {
		if (x == 0)
			return true;

		if (checking(x / 10, wrap) && (x % 10 == wrap.val % 10)) {
			wrap.val = wrap.val / 10;
			return true;
		} else
			return false;
	}

	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0)
			return false;

		if (x < 10)
			return true;

		IntWrapper wrap = new IntWrapper(x);

		return checking(x, wrap);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
