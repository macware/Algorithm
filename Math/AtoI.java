package Math;

public class AtoI {

	/*
	 * atoi. An integer might overflow, managing it with long type or unsigned
	 * int type. Also note that the max_int and min_int are not opposite
	 * numbers. INT_MAX (2147483647) INT_MIN (-2147483648) Remember to tackle
	 * the whitespace blind point.
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

	public int atoi2(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null || str.length() == 0)
			return 0;

		int i, sign;
		i = sign = 0;

		// ignore the leading whitespaces
		while (str.charAt(i) == ' ')
			i++;

		// check the sign
		char c = str.charAt(i);
		if (c == '-')
			sign = -1;
		else if (c == '+')
			sign = 1;

		if (sign == 0)
			sign = 1;
		else
			i++;

		long res = 0;
		while (i < str.length()) {
			c = str.charAt(i);
			if (c >= '0' && c <= '9')
				res = res * 10 + c - '0';
			else
				break;
			i++;
		}

		if (res == 0)
			return 0;
		if (res > Integer.MAX_VALUE) {
			if (sign == 1)
				return Integer.MAX_VALUE;
			if (sign == -1)
				return Integer.MIN_VALUE;
		}

		return (int) (sign * res);
	}

	public int atoi_ugly(String str) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (str == null || str.length() == 0)
			return 0;

		int i = 0, sign = 0;
		long n = 0;
		char c = str.charAt(0);
		while (c == ' ' && i < str.length()) {
			i++;
			c = str.charAt(i);
		}

		while (i < str.length()) {
			c = str.charAt(i);
			if (c == '+') {
				if (sign != 0)
					return 0;
				sign = 1;
			} else if (c == '-') {
				if (sign != 0)
					return 0;
				sign = -1;

			} else if (c >= '0' && c <= '9')
				n = n * 10 + c - '0';
			else
				break;
			i++;
		}

		if (sign >= 0 && n > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (sign == -1 && n > Integer.MAX_VALUE)
			return Integer.MIN_VALUE;

		if (sign == 0)
			sign = 1;

		return (int) (sign * n);
	}

	public int atoi_best(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (str == null || str.length() == 0)
            return 0;
        
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        
        if (i == str.length())
            return 0;
            
        int sign = 1;
        char c = str.charAt(i);
        if (c == '-'){
            sign = -1;
            i++;
        } else if (c == '+')
            i++;
        
        long n = 0;
        while (i < str.length()){
            c = str.charAt(i);
            if (c >= '0' && c <= '9')
                n = n*10 + c-'0';
            else
                break;
            i++;
        }
        
        System.out.println(n);
        
        if (n > Integer.MAX_VALUE){
            if (sign == 1)
                return Integer.MAX_VALUE;
            if (sign == -1)
                return Integer.MIN_VALUE;
        }
            
        return (int)(sign * n);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtoI atoi = new AtoI();
		System.out.println(atoi.atoi_best("-1"));
	}

}
