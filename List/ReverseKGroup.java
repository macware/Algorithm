package List;

public class ReverseKGroup {
	
	public ListNode addFront(ListNode head, ListNode node) {
		ListNode newHead = node;
		newHead.next = head;

		return newHead;
	}

	public ListNode reverseList(ListNode head) {
		ListNode rem, cur;
		ListNode newHead = null;

		cur = head;
		while (cur != null) {
			rem = cur.next;
			cur.next = newHead;
			newHead = cur;

			cur = rem;
		}

		if (newHead == null)
			newHead = head;

		return newHead;
	}

	/*
	 * Reverse K group. Record the three sets of data: result (res & resEnd),
	 * new (newGroup & groupEnd), frontier (remains)
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode rem, cur;
		ListNode res, resEnd, newGroup, groupEnd;

		cur = head;
		res = resEnd = newGroup = groupEnd = null;
		int i = 0;

		while (cur != null) {
			if (newGroup == null)
				groupEnd = cur;

			rem = cur.next;
			newGroup = addFront(newGroup, cur);
			i++;
			if (i == k) {
				// Form a new group
				if (res != null)
					resEnd.next = newGroup;
				else
					res = newGroup;

				resEnd = groupEnd;
				newGroup = null;
				i = 0;
			}

			if (rem == null)
				break;
			cur = rem;
		}

		if (res != null && newGroup != null)
			resEnd.next = reverseList(newGroup);

		if (res == null && newGroup != null)
			res = reverseList(newGroup);

		return res;
	}

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

	public ListNode reverse(ListNode list) {
		ListNode head = null;
		ListNode rem, cur, tmp;

		cur = list.next;
		tmp = cur;
		list.next = null;

		while (cur != null) {
			rem = cur.next;
			cur.next = head;
			head = cur;
			cur = rem;
		}

		tmp.next = head;
		return tmp;
	}

	public ListNode concat(ListNode list1, ListNode list2) {
		if (list1 != null) {
			ListNode head1 = list1.next;
			ListNode head2 = list2.next;
			list1.next = head2;
			list2.next = head1;
		}

		return list2;
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
