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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
