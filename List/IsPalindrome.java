package List;

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

	private Result isPalindrome2(ListNode start, int length){
		if (length == 1)
			return new Result(start.next,true);
		
		if (length == 2)
			return new Result(start.next.next, start.val == start.next.val);
		
		Result res = isPalindrome2(start.next, length - 2);
		if (!res.result)
			return res;
		
		if (start.val == res.node.val)
			res.node = res.node.next;
		else
			res.result = false;
			
		return res;
	}
	
	private Result isPalindrome(ListNode from, int length) {
		if (length == 1) {
			return new Result(from.next, true);
		} else if (length == 2) {
			if (from.val == from.next.val)
				return new Result(from.next.next, true);
			else
				return new Result(null, false);
		}

		Result res = isPalindrome(from.next, length - 2);
		if (res.result == false)
			return res;

		if (res.node.val == from.val)
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

		return isPalindrome2(list.getStart(), length).result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new List();
		int i, n = 1;
		for (i = 0; i < n; i++) {
			list.appendNode(i);
		}
		list.appendNode(n);
		if (n % 2 == 0)
			list.appendNode(n);
		for (i = n - 1; i >= 0; i--) {
			list.appendNode(i-1);
		}

		list.printList();
		IsPalindrome ip = new IsPalindrome();
		System.out.println("Check result: " + ip.checkPalindrome(list));
	}

}
