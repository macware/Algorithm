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
	
	public int longestValidParentheses2(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxLen = 0;
        int validStart = s.length();
        Stack<Integer> pos = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(')
                pos.push(i);
            else if (pos.isEmpty())
                validStart = s.length();
            else {
            	// remember the minimum valid start position so far
                validStart = Math.min(validStart,pos.pop());
                int newLen = i - validStart + 1;
                // adjust to the current valid part
                if (!pos.isEmpty())
                    newLen = i - pos.peek();
                maxLen = Math.max(maxLen, newLen);
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
