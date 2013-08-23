package List;

public class DeleteDups {

	public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null)
            return head;
        
        ListNode tagNode, cur, rem;
        
        tagNode = head;
        cur = head.next;
        rem = null;
        while (cur!= null){
            rem = cur.next;
            if (cur.val == tagNode.val){
                tagNode.next = rem;
            } else {
                tagNode = tagNode.next;
            }    
            cur = rem;
        }
        
        return head;
    }
	
	public ListNode deleteDuplicates2(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode tag, cur;
        tag = head;
        while (tag != null){
            cur = tag.next;
            if (cur != null && tag.val == cur.val)
                tag.next = cur.next;
            else 
                tag = cur;
        }
        
        return head;
    }
	
	public ListNode removeDuplicated(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if (head == null || head.next == null)
            return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode parent,cur,next;
        parent = newHead;
        cur = head;
        next = head.next;
        boolean has_dup = false; 
        
        while (cur!= null && next != null){
            if (next.val == cur.val){
                parent.next = next.next;
                next = parent.next;
                has_dup = true;
            } else {
                if (!has_dup)
                    parent = parent.next;
                cur = parent.next;
                if (cur == null)
                    break;
                next = cur.next;
                has_dup = false;
            }
        }
        
        return newHead.next;
    }
	
	public ListNode removeDuplicates2(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null)
            return null;
            
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode tag = head, cur, p = fake;
        int count = 1;
        
        cur = tag.next;
        while (cur != null){
            if (cur.val == tag.val)
                count++;
            else if (count == 1){
                p.next = tag;
                p = p.next;
                tag = tag.next;
            } else {
                tag = cur;
                count = 1;
            }
            
            cur = cur.next;
        }
        
        if (count == 1)
            p.next = tag;
        else
            p.next = null;
            
        return fake.next;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
