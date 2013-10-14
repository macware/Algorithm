package Search;

public class ZigZag {

	/*
	 * Zig-Zag print.
	 */
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (nRows == 1)
			return s;

		StringBuffer buf = new StringBuffer();
		int diff = nRows + nRows - 2;
		for (int i = 0; i < nRows; i++) {
			int index = i;
			while (index < s.length()) {
				buf.append(s.charAt(index));
				index += diff;
				if (i != 0 && i != nRows - 1 && index - i - i < s.length()) {
					buf.append(s.charAt(index - i - i));
				}
			}
		}

		return buf.toString();
	}

	public String convert2(String s, int nRows) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0 || nRows <= 0)
			return s;

		StringBuilder sb = new StringBuilder();
		int n, diff = nRows + nRows - 2;
		for (int i = 0; i < nRows; i++) {
			n = i;
			while (n < s.length()) {
				sb.append(s.charAt(n));
				n += diff;
				if (i != 0 && i != nRows - 1 && n - i - i < s.length())
					sb.append(s.charAt(n - i - i));
			}
		}

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZag zz = new ZigZag();
		System.out.println(zz.convert2("PAYPALISHIRING", 3));
	}

}
