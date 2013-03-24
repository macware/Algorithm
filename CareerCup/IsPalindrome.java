package CareerCup;

import List.*;

// Chapter 2
public class IsPalindrome {

	class Result {
		public ListNode node;
		public boolean result;

		public Result(ListNode n, boolean res) {
			node = n;
			result = res;
		}
	}

	public IsPalindrome() {

	}

	private Result isPalindrome(ListNode from, int length) {
		if (length == 1) {
			return new Result(from.next, true);
		} else if (length == 2) {
			if (from.data == from.next.data)
				return new Result(from.next.next, true);
			else
				return new Result(null, false);
		}

		Result res = isPalindrome(from.next, length - 2);
		if (res.result == false)
			return res;

		if (res.node.data == from.data)
			res.node = res.node.next;

		else
			res.result = false;

		return res;
	}

	public boolean checkPalindrome(List list) {
		ListNode cur = list.getStart();

		if (cur == null)
			return false;

		int length = 0;
		while (cur != null) {
			length++;
			cur = cur.next;
		}

		return isPalindrome(list.getStart(), length).result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new List();
		int i, n = 4;
		for (i = 0; i < n; i++) {
			list.appendNode(i);
		}
		list.appendNode(n);
		for (i = n - 1; i >= 0; i--) {
			list.appendNode(i);
		}

		list.printList();
		IsPalindrome ip = new IsPalindrome();
		System.out.println("Check result: " + ip.checkPalindrome(list));
	}

}
