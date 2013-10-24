package List;

public class Merge2Lists {
	public ListNode append(ListNode list, ListNode node){
        if (list == null)
            node.next = node;
        else {
            node.next = list.next;
            list.next = node;
        }
        
        return node;
    }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode res, rem = null;
        res = null;
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                rem = l1.next;
                res = append(res,l1);
                l1 = rem;
            } else {
                rem = l2.next;
                res = append(res,l2);
                l2 = rem;
            }
        }
        
        if (l1 == null)
            l1 = l2;
        
        while (l1 != null){
            rem = l1.next;
            res = append(res,l1);
            l1 = rem;
        }
        
        if (res != null){
            rem = res.next;
            res.next = null;
        }
        
        return rem;
    }
	
	public ListNode mergeTwoLists_best(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode strap = new ListNode(-1);
        ListNode cur = strap;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;
        
        return strap.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
