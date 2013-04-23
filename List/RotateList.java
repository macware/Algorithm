package List;

public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0 || head == null || head.next == null)
            return head;
            
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        
        ListNode parent;
        int k = n % len;
        if (k == 0)
            return head;
        
        cur = head;
        while (k > 0){
            cur = cur.next;
            k--;
        }
        parent = head;
        
        while (cur.next != null){
            cur = cur.next;
            parent = parent.next;
        }
        
        cur.next = head;
        ListNode newHead = parent.next;
        parent.next = null;
        
        return newHead;
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
