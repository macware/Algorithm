package List;

public class ReverseBetween {

	public ListNode addFront(ListNode list, ListNode node) {
		ListNode rear = list;
		if (rear == null) {
			node.next = node;
			rear = node;
		} else {
			node.next = rear.next;
			rear.next = node;
		}

		return rear;
	}

	public ListNode reverseBetween1(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m < 0 || n < 0 || m == n || head == null || head.next == null)
			return head;

		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode mParent, cur, rem = null;
		ListNode pList = null;

		mParent = newHead;
		cur = head;
		int i = 1;

		while (cur != null) {
			rem = cur.next;
			if (i >= m && i <= n) {
				pList = addFront(pList, cur);
			}

			if (i < m) {
				mParent = mParent.next;
			}

			if (i == n) {
				break;
			}

			i++;
			cur = rem;
		}

		mParent.next = pList.next;
		pList.next = rem;

		return newHead.next;
	}

	public ListNode insertFront(ListNode list, ListNode node) {
		if (list == null) {
			node.next = node;
			return node;
		}

		node.next = list.next;
		list.next = node;
		return list;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode fake = new ListNode(0);
		fake.next = head;

		ListNode list = null, rem = null, parent = fake, cur = head;
		int k = 1;

		while (cur != null) {
			rem = cur.next;
			if (k >= m)
				list = insertFront(list, cur);
			else
				parent = cur;

			if (k == n)
				break;

			cur = rem;
			k++;
		}

		if (list != null) {
			parent.next = list.next;
			list.next = rem;
		}

		return fake.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
