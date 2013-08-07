package List;

public class SwapPairs {

	/*
	 * Keep in mind the modification principal: check null + modify at the
	 * parent level. Use the padding technique to make your work convenient.
	 */
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null)
			return head;

		ListNode parent = new ListNode(0);
		ListNode newHead, cur, next;

		cur = head;
		next = cur.next;
		newHead = next;

		while (next != null) {
			cur.next = next.next;
			next.next = cur;
			parent.next = next;

			parent = parent.next.next;
			if (parent == null || parent.next == null)
				break;

			cur = parent.next;
			next = cur.next;
		}

		return newHead;
	}
	
	public ListNode swapPairs2(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
            
        ListNode fake = new ListNode(0);
        fake.next = head;
        
        ListNode parent, node1, node2;
        parent = fake;
        node1 = head;
       
        while (node1 != null){
            node2 = node1.next;
            if (node2 == null)
                break;
                
            node1.next = node2.next;
            node2.next = node1;
            parent.next = node2;
            
            parent = node1;
            node1 = parent.next;
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
