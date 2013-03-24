package LeetCode;

import java.util.Stack;

public class DP_Part1 {
	/*
	 * Valid parenthesis. While visiting an element from a data structure, check
	 * empty first!
	 */
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0 || s.length() % 2 == 1)
			return false;

		Stack<Character> cstack = new Stack<Character>();
		Character c;

		int i = 0;
		for (i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch (c) {
			case '(':
			case '[':
			case '{':
				cstack.push(c);
				break;

			case ')':
				if (cstack.size() == 0 || cstack.peek() != '(')
					return false;
				cstack.pop();
				break;

			case ']':
				if (cstack.size() == 0 || cstack.peek() != '[')
					return false;
				cstack.pop();
				break;

			case '}':
				if (cstack.size() == 0 || cstack.peek() != '{')
					return false;
				cstack.pop();
				break;

			default:
				return false;
			}
		}

		if (cstack.size() != 0)
			return false;

		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
