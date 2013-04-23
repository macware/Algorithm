package Math;

public class IntToRoman {

	String[] digits = new String[] { "One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten" };
	String[] teens = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	String[] tens = { "Ten", "Tweenty", "Thirty", "Forty", "Fifty", "Sixty",
			"Seventy", "Eighty", "Ninety" };
	String[] bigs = { "", "Thousand", "Million" };

	String numToString(int num) {
		if (num == 0) {
			return "Zero";
		} else if (num < 0) {
			return "Negative" + numToString(-1 * num);
		}

		int count = 0;
		String str = "";

		while (num > 0) {
			if (num % 1000 > 0) {
				str = numToString100(num % 1000) + bigs[count] + " " + str;
			}
			num /= 1000;
			count++;
		}

		return str;
	}

	private String numToString100(int i) {
		// TODO Auto-generated method stub
		String str = "";

		if (i >= 100) {
			str += digits[i / 100 - 1] + " Hundred ";
			i %= 100;
		}

		if (i >= 11 && i <= 19) {
			str += teens[i - 11] + " ";
		} else if (i == 10 || i >= 20) {
			str += tens[i / 10 - 1] + " ";
			i %= 10;
		}

		if (i > 0) {
			str += digits[i - 1] + " ";
		}

		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntToRoman itr = new IntToRoman();
		System.out.println(itr.numToString(1234567));
	}

}
