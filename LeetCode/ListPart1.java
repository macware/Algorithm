package LeetCode;

import java.util.*;

import List.ListNode;

public class ListPart1 {

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
	 * Longest substring without repeating characters If possible, use an
	 * example to test your thought and find some blind mistakes Think carefully
	 * when you decide to start a new round, reset or backtrack? Did you really
	 * finish all the work after the main loop. (Counting problem needs final
	 * check) How to slickly detect a old record. (Record a valid pos/time,
	 * indicating a valid start point)
	 */
	public static int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

		int newLen, max;
		int validPos = 0;
		max = newLen = 0;

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (chars.containsKey(c) && chars.get(c) >= validPos) {
				if (newLen > max)
					max = newLen;

				validPos = chars.get(c) + 1;
				newLen = i - validPos;
			}

			chars.put(c, i);
			newLen++;
		}

		if (newLen > max)
			max = newLen;

		return max;
	}

	/*
	 * Add two numbers Use the node modification technique: check null + modify
	 * at parent level
	 */

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ListNode ans, upNode, downNode;

		upNode = l1;
		downNode = l2;
		int res, carry = 0;

		if (upNode == null) {
			upNode = l2;
			downNode = l1;
			ans = l2;
		} else {
			ans = l1;
		}

		if (ans == null)
			return ans;

		while (true) {
			res = upNode.val + carry;
			if (downNode != null)
				res += downNode.val;

			if (res >= 10) {
				carry = 1;
				res = res - 10;
			} else
				carry = 0;

			upNode.val = res;
			if (upNode.next == null && downNode != null) {
				upNode.next = downNode.next;
				downNode.next = null;
			}

			if (upNode.next == null) {
				if (carry > 0) {
					upNode.next = new ListNode(carry);
				}
				break;
			}

			upNode = upNode.next;
			if (downNode != null)
				downNode = downNode.next;
		}

		return ans;
	}

	public void test() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);

		ListNode l2 = new ListNode(0);

		ListNode ans = addTwoNumbers(l1, l2);
		while (ans != null) {
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

	/*
	 * Longest palindromic substring in S Choose the straight forward metric and
	 * not to measure slickly in the technique interview. You'd better calculate
	 * the correct length.
	 */
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (s.length() <= 1)
			return s;

		int start, end, newLen, maxLen;
		int i, p, q;

		newLen = maxLen = 0;
		start = end = 0;

		for (i = 0; i < s.length(); i++) {
			// count for the odd case
			p = i - 1;
			q = i + 1;

			while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
				newLen++;
				p--;
				q++;
			}

			newLen = 2 * newLen + 1;
			if (maxLen < newLen) {
				maxLen = newLen;
				start = p + 1;
				end = q - 1;
			}
			newLen = 0;

			// count for the even case
			p = i;
			q = i + 1;
			while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
				newLen++;
				p--;
				q++;
			}

			newLen = 2 * newLen;
			if (maxLen < newLen) {
				maxLen = newLen;
				start = p + 1;
				end = q - 1;
			}
			newLen = 0;

		}

		return s.substring(start, end + 1);

	}

	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (nRows == 1)
			return s;

		StringBuffer buf = new StringBuffer();
		int diff = nRows + nRows - 2;
		for (int i = 0; i < nRows; i++) {
			int index = i;
			while (index < s.length()) {
				buf.append(s.charAt(index));
				index += diff;
				if (i != 0 && i != nRows - 1 && index - i - i < s.length()) {
					buf.append(s.charAt(index - i - i));
				}
			}
		}

		return buf.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListPart1 oj = new ListPart1();
		System.out.println(oj.convert("PAYPALISHIRING", 3));
	}

}
