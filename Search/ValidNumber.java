package Search;

public class ValidNumber {

	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0)
			return false;

		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) != ' ')
				break;
			i++;
		}

		boolean dotAppear, eAppear, firstPart, secondPart, firstSign, secondSign;
		dotAppear = eAppear = firstPart = secondPart = firstSign = secondSign = false;
		
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == ' ')
				break;
			else if (c == '.') {
				if (dotAppear || eAppear)
					return false;
				dotAppear = true;
			} else if (c == 'e' || c == 'E') {
				if (eAppear)
					return false;
				eAppear = true;
			} else if (c == '+' || c == '-') {
				if (secondPart || secondSign)
					return false;
				if (eAppear)
					secondSign = true;
				else if (firstPart || firstSign || dotAppear)
					return false;
				else
					firstSign = true;
			} else if (c >= '0' && c <= '9') {
				if (eAppear)
					secondPart = true;
				else
					firstPart = true;
			} else
				return false;
			i++;
		}

		while (i < s.length()) {
			if (s.charAt(i) != ' ')
				return false;
			i++;
		}

		if (!firstPart || (eAppear && !secondPart))
			return false;

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("    "));
	}

}
