package Math;

public class AtoI {

	/*
	 * atoi. An integer might overflow, managing it with long type or unsigned
	 * int type. Also note that the max_int and min_int are not opposite
	 * numbers. INT_MAX (2147483647) INT_MIN (-2147483648)
	 * Remember to tackle the whitespace blind point.
	 */
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null || str.length() == 0)
			return 0;

		// Find the first digit
		int i, signed = 0;
		boolean finded = false;

		for (i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case ' ':
				if (signed != 0)
					return 0;
				continue;

			case '+':
				if (signed == 0)
					signed = 1;
				else
					return 0;
				break;

			case '-':
				if (signed == 0)
					signed = -1;
				else
					return 0;
				break;

			default:
				finded = true;
			}

			if (finded)
				break;
		}

		if (!finded)
			return 0;
		if (signed == 0)
			signed = 1;

		long res = 0;

		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				res = res * 10 + c - '0';
				if (res > Integer.MAX_VALUE) {
					if (signed == 1)
						return Integer.MAX_VALUE;
					if (signed == -1)
						return Integer.MIN_VALUE;
				}
			} else
				break;
		}

		return (int) (signed * res);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
