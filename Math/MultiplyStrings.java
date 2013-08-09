package Math;

import java.util.Arrays;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num1.length() == 0 || num2.length() == 0 || num1.charAt(0) == '0'
				|| num2.charAt(0) == '0')
			return "0";

		char[] res = new char[num1.length() + num2.length()];
		Arrays.fill(res, '0');

		int sum, carry;
		for (int i = num2.length() - 1; i >= 0; i--) {
			
			carry = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				sum = num2.charAt(i) - '0';
				sum *= (num1.charAt(j) - '0');
				sum += (res[i + j + 1] - '0');
				sum += carry;

				carry = sum / 10;
				sum %= 10;

				res[i + j + 1] = (char) (sum + '0');
			}

			res[i] = (char) (carry + '0');
		}

		int offset = 0;
		if (res[0] == '0')
			offset = 1;

		return new String(res, offset, res.length - offset);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply("99", "99"));
	}

}
