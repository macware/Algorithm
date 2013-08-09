package Search;

import java.util.*;

public class ValidParenthesis {

	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;

				char cprime = stack.pop();
				boolean valid = (c == ')' && cprime == '(');
				valid = valid || (c == ']' && cprime == '[');
				valid = valid || (c == '}' && cprime == '{');

				if (!valid)
					return false;
			}
		}

		if (stack.isEmpty())
			return true;

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
