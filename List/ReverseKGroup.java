package List;

public class ReverseKGroup {
	/*
	 * Circular trick: if we want to record the front and rear of a list at the
	 * same time, this trick can save space and more convenient.
	 */
	public ListNode append(ListNode list, ListNode newNode) {
		ListNode res = newNode;
		if (list == null)
			res.next = res;
		else {
			res = list;
			newNode.next = list.next;
			list.next = newNode;
		}
		return res;
	}

	public ListNode reverseKGroup_circular(ListNode head, int k) {
		if (head == null)
			return null;

		ListNode res = null;
		ListNode rem, cur, newList;

		int n = 0;

		cur = head;
		newList = null;
		while (cur != null) {
			rem = cur.next;
			newList = append(newList, cur);
			n++;
			if (n == k) {
				res = concat(res, newList);
				newList = null;
				n = 0;
			}
			cur = rem;
		}

		if (newList != null) {
			newList = reverse(newList);
			res = concat(res, newList);
		}

		ListNode ret = res.next;
		res.next = null;

		return ret;
	}

	/*
	 * The third time
	 */
	public ListNode addFront(ListNode list, ListNode node) {
		if (list == null) {
			node.next = node;
			return node;
		}

		node.next = list.next;
		list.next = node;

		return list;
	}

	public ListNode concat(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		ListNode head = l1.next;
		l1.next = l2.next;
		l2.next = head;

		return l2;
	}

	public ListNode reverse(ListNode l) {
		ListNode tail = l.next;
		ListNode res = null, cur = l.next, rem;
		l.next = null;

		while (cur != null) {
			rem = cur.next;
			cur.next = res;
			res = cur;
			cur = rem;
		}

		tail.next = res;
		return tail;
	}

	public ListNode reverseKGroup3(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || k <= 0)
			return head;

		ListNode res = null, list = null, cur = head, rem;
		int n = 0;
		while (cur != null) {
			rem = cur.next;
			list = addFront(list, cur);
			n++;
			if (n == k) {
				res = concat(res, list);
				list = null;
				n = 0;
			}
			cur = rem;
		}

		if (list != null)
			list = reverse(list);

		res = concat(res, list);
		if (res != null) {
			rem = res.next;
			res.next = null;
			res = rem;
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
