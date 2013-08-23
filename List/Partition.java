package List;

public class Partition {

	public ListNode append(ListNode list, ListNode node) {
		if (list == null)
			node.next = node;
		else {
			node.next = list.next;
			list.next = node;
		}

		return node;
	}

	public ListNode concat(ListNode low, ListNode high) {
		if (low == null)
			return null;

		ListNode res = low.next;
		low.next = null;
		if (high != null) {
			low.next = high.next;
			high.next = null;
		}

		return res;
	}

	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode low = null, high = null, cur = head, rem;
		while (cur != null) {
			rem = cur.next;
			if (cur.val < x)
				low = append(low, cur);
			else
				high = append(high, cur);

			cur = rem;
		}

		if (low == null) {
			low = high;
			high = null;
		}

		return concat(low, high);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
