package Math;

public class IntPalidrome {

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
