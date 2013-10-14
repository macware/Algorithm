package String;

import java.util.*;

public class NumDisSeq {

	/*
	 * Fix the target T. Dp on the length of the source S. String Matching:
	 * Usually figure a way out by base and building up (from the length of
	 * source 0 to the actual length). Sometimes it turns out to be a DP fashion
	 * (Filling a two dimension table) and can be reduced space by reusing the
	 * previous result in a decreasing iterative way.
	 */
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S == null || T == null || S.length() == 0)
			return 0;

		int[] count = new int[T.length() + 1];
		count[0] = 1;

		for (int i = 0; i < S.length(); i++) {
			for (int j = T.length(); j >= 1; j--) {
				if (T.charAt(j - 1) == S.charAt(i))
					count[j] += count[j - 1];
			}
		}

		return count[T.length()];
	}

	public int numDistinct1(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S == null && T == null)
			return 1;
		if (S == null || T == null)
			return 0;

		int[] dp = new int[T.length() + 1];
		dp[0] = 1;

		int i, j;
		for (i = 1; i <= S.length(); i++) {
			for (j = T.length(); j >= 1; j--)
				if (S.charAt(i - 1) == T.charAt(j - 1))
					dp[j] += dp[j - 1];
		}

		return dp[T.length()];
	}

	/*
	 * Target as the column, dp on the length of Source
	 */
	public int numDistinct2(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] dp = new int[T.length() + 1];
		dp[0] = 1;

		for (int i = 0; i < S.length(); i++) {
			for (int j = T.length() - 1; j >= 0; j--) {
				if (S.charAt(i) == T.charAt(j))
					dp[j + 1] += dp[j];
			}
		}

		return dp[T.length()];
	}

	public int numDistinct3(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S == null && T == null)
			return 1;
		if (S == null || T == null)
			return 0;

		int[] dp = new int[T.length() + 1];
		dp[0] = 1;

		int i, j;
		for (i = 1; i <= S.length(); i++) {
			for (j = T.length(); j >= 1; j--)
				if (S.charAt(i - 1) == T.charAt(j - 1))
					dp[j] += dp[j - 1];
		}

		return dp[T.length()];
	}

	public int solution(String S) {
		// write your code here...
		if (S == null || S.length() == 0)
			return -1;

		Stack<Integer> stack = new Stack<Integer>();
		int tmp = 0;
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			if (c >= '0' && c <= '9')
				tmp = c - '0';
			else if (c == '+') {
				if (stack.size() < 2)
					return -1;
				tmp = stack.pop() + stack.pop();
			} else if (c == '*') {
				if (stack.size() < 2)
					return -1;
				tmp = stack.pop() * stack.pop();
			} else
				return -1;

			if (tmp >= (1 << 12))
				return -1;

			stack.push(tmp);
		}

		if (stack.size() != 1)
			return -1;

		return stack.pop();
	}

	// Wrong answer
	public int solution_fancy(int[] A) {
		// write your code here...
		if (A == null || A.length == 0)
			return -1;

		int bound = 0;
		int max_so_far = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] > A[max_so_far])
				max_so_far = i;
			
			if (A[i] < A[bound])
				bound = max_so_far;
		}
		
		if (bound == max_so_far)
			return -1;
		
		return bound;
	}

	public int solution(int[] A) {
		// write your code here...
		if (A == null || A.length == 0)
			return -1;

		int[] max = new int[A.length];
		int[] min = new int[A.length];

		int i, max_so_far = A[0];
		for (i = 0; i < A.length; i++) {
			if (A[i] > max_so_far)
				max_so_far = A[i];
			max[i] = max_so_far;
		}

		int min_so_far = A[A.length - 1];
		for (i = A.length - 1; i >= 0; i--) {
			if (A[i] < min_so_far)
				min_so_far = A[i];
			min[i] = min_so_far;
		}

		for (i = 0; i < A.length; i++) {
			if (max[i] == min[i])
				return i;
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumDisSeq nds = new NumDisSeq();
		System.out.println(nds.solution_fancy(new int[]{2,1,3,3,4,5,2}));

	}
}
