package LeetCode;

import java.util.*;
import List.*;

public class OJPart3 {

	/*
	 * Indice is really complicated. Think carefully, usually the start index is
	 * included while the end index depends on the problem and your
	 * implementation. The loops record n steps(last record) you already made
	 * when you break the loop, i.e, n steps further than the origin (n+1 nodes
	 * inclusively). for, while, do-while loops have the same effect if i starts
	 * from 0 and n != 0; As for n steps(first record), n steps mean n nodes you
	 * already have inclusively when the loop is broken.
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0)
			return null;

		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			if (fast == null)
				return null;
			fast = fast.next;
		}

		if (fast == null)
			return head.next;

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return head;
	}

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

	public class Part implements Comparable<Part> {
		public int start;
		public int end;

		public Part(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Part p) {
			// TODO Auto-generated method stub
			if (start < p.start)
				return -1;
			else if (start > p.start)
				return 1;

			return 0;
		}
	}

	public void testPart() {
		ArrayList<Part> partList = new ArrayList<Part>();
		partList.add(new Part(8, 10));
		partList.add(new Part(1, 3));
		partList.add(new Part(15, 18));
		partList.add(new Part(2, 6));

		Collections.sort(partList);

		for (Part p : partList)
			System.out.println("[" + p.start + "," + p.end + "]");
	}

	/*
	 * This is the right version of max sum!
	 */
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (max < sum) {
				max = sum;
			}

			if (sum < 0) {
				sum = 0;
			}
		}

		return max;
	}

	/* 
     * 
     */
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (height == null || height.length == 0)
			return 0;

		if (height.length == 1)
			return height[0];

		Stack<Integer> ints = new Stack<Integer>();
		ints.push(height[0]);

		int j = 1;
		int max = 0;

		while (j < height.length) {
			if (height[j] >= ints.peek()) {
				ints.push(height[j]);
				j++;
			} else {
				int count = 1;
				while (ints.size() > 0 && ints.peek() > height[j]) {
					max = Math.max(max, ints.pop() * count);
					count++;
				}

				for (int i = 0; i < count; i++) {
					ints.push(height[j]);
				}
				j++;
			}
		}

		if (ints.size() > 0) {
			int count = 1;
			while (ints.size() > 0) {
				max = Math.max(max, ints.pop() * count);
				count++;
			}
		}

		return max;
	}

	/*
	 * Permutation sequence
	 */
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n <= 0 || k <= 0) {
			return null;
		}

		StringBuilder res = new StringBuilder();
		ArrayList<Integer> num = new ArrayList<Integer>();
		int d, i;
		d = 1;
		for (i = 1; i <= n; i++) {
			num.add(i);
			d *= i;
		}

		if (k > d)
			return null;

		int idx;
		for (i = n; i >= 1; i--) {
			d /= i;
			idx = (k - 1) / d;
			k -= idx * d;
			res.append(num.get(idx));
			num.remove(idx);
		}

		return res.toString();
	}

	/*
	 * 4,1,4,2,2,2,0 4,2,0,2,3,2,0 4,2,2,0,0,2,3 4,2,0,3,0,2,2
	 */
	/*
	 * NextPermutation. This is similar to the problem of career cup 5.3, which
	 * cares about binary format, but here, we concentrates on decimal format.
	 * However, the idea are the same: Flip and then rearrange numbers that
	 * followed. Here 0 means a decreasing point, 1 means keep increasing.
	 */
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (num == null || num.length < 2) {
			return;
		}

		int i, j;
		for (i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				for (j = num.length - 1; j >= i+1; j--) {
					if (num[j] > num[i]) {
						int temp = num[j];
						num[j] = num[i];
						num[i] = temp;

						Arrays.sort(num, i + 1, num.length);
						return;
					}
				}
			}
		}

		return;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OJPart3 oj = new OJPart3();
		int[] num = new int[]{1,2,3,4,5};
		oj.nextPermutation(num);
		for (int i = 0; i < num.length; i++){
			System.out.print(num[i]);
		}

	}

}
