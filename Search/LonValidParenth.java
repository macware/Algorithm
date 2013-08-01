package Search;

import java.util.Stack;

public class LonValidParenth {

	/*
	 * The key idea is how to record and merge with earlier result. Stack has
	 * this property
	 */
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null | s.length() < 2)
			return 0;

		int newLen, maxLen;
		int startIdx;

		// Record earlier result
		Stack<Integer> stack = new Stack<Integer>();
		
		startIdx = s.length();
		newLen = maxLen = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
				continue;
			}

			if (stack.isEmpty()){
				// Couldn't merge with previous result
				startIdx = s.length();
			}else {
				// Try to merge with earlier match
				startIdx = Math.min(startIdx, stack.pop());
				
				if (stack.isEmpty())
					newLen = i - startIdx + 1;
				else{
					// merge until stack.peek() (exclusive)
					newLen = i - stack.peek();
				}

				maxLen = Math.max(newLen, maxLen);
			}
		}

		return maxLen;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
