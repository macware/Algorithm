package Math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

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

	public String intToRoman2(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String roman = "IVXLCDM";
		Stack<Character> stack = new Stack<Character>();
		int i;
		for (int base = 0; num > 0; num /= 10, base += 2) {
			int x = num % 10;
			switch (x) {
			case 1:
			case 2:
			case 3:
				for (i = 0; i < x; i++)
					stack.push(roman.charAt(base));
				break;

			case 4:
				stack.push(roman.charAt(base + 1));
				stack.push(roman.charAt(base));
				break;
			case 5:
				stack.push(roman.charAt(base + 1));
				break;

			case 6:
			case 7:
			case 8:
				for (i = 5; i < x; i++)
					stack.push(roman.charAt(base));
				stack.push(roman.charAt(base + 1));
				break;

			case 9:
				stack.push(roman.charAt(base + 2));
				stack.push(roman.charAt(base));
				break;

			default:
				break;
			}
		}

		StringBuffer ret = new StringBuffer();
		while(!stack.isEmpty())
			ret.append(stack.pop());
		return ret.toString();
	}
	
	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String roman = "IVXLCDM";
		StringBuffer ret = new StringBuffer();
		char[] tmp;
		for (int base = 0; num > 0; num /= 10, base += 2) {
			int x = num % 10;
			switch (x) {
			case 1:
			case 2:
			case 3:
				tmp = new char[x];
				Arrays.fill(tmp, roman.charAt(base));
				ret.insert(0,tmp);
				break;

			case 4:
				ret.insert(0,roman.charAt(base + 1));
				ret.insert(0, roman.charAt(base));
				break;
			case 5:
				ret.insert(0,roman.charAt(base + 1));
				break;

			case 6:
			case 7:
			case 8:
				tmp = new char[x - 5];
				Arrays.fill(tmp, roman.charAt(base));
				ret.insert(0,tmp);
				ret.insert(0,roman.charAt(base+1));
				break;

			case 9:
				ret.insert(0,roman.charAt(base + 2));
				ret.insert(0,roman.charAt(base));
				break;

			default:
				break;
			}
		}

		return ret.toString();
	}

	public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret = 0;
        if (0 == s.length())
            return ret;
            
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        ret = map.get(s.charAt(s.length()-1));
        for (int i = s.length() - 2; i >= 0; i--){
            if (map.get(s.charAt(i+1)) <= map.get(s.charAt(i)))
                ret += map.get(s.charAt(i));
            else
                ret -= map.get(s.charAt(i));
        }
        
        return ret;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntToRoman itr = new IntToRoman();
		String res = itr.intToRoman(1994);
		System.out.println(res);
		System.out.println(itr.romanToInt("XXIV"));
	}

}
