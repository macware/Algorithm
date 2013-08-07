package List;

public class RemoveNth {

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
	 * Use padding technique: pad a dummy parent to the head in case of removing
	 * the head
	 */
	public ListNode removeNthFromEnd_padding(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0 || head == null)
			return head;

		ListNode parent = new ListNode(-1);
		ListNode res = parent;
		parent.next = head;

		ListNode runner = head;
		for (int i = 1; i < n; i++) {
			if (runner == null)
				return head;
			runner = runner.next;
		}
		
		while (runner.next != null){
			runner = runner.next;
			parent = parent.next;
		}
		
		// Recall the figure while modifying a node
		// Don't make stupid mistakes
		parent.next = parent.next.next;
		
		return res.next;
	}

	public ListNode removeNthFromEnd_padding2(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fake = new ListNode(0);
        fake.next = head;
        
        ListNode back,front;
        back = fake;
        front = head;
        
        int i = 1;
        while (i < n){
            front = front.next;
            i++;
        }
        
        while (front.next != null){
            front = front.next;
            back = back.next;
        }
        
        back.next = back.next.next;
        
        return fake.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
