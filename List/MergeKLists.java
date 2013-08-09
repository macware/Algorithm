package List;
import java.util.*;
public class MergeKLists {

	public ListNode addToList(ListNode list, ListNode node){
        if (list == null){
            node.next = node;
        }else{
            node.next = list.next;
            list.next = node;
        }
        
        return node;
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode rem, left, right;
        ListNode res = null;
        if (lists.size() > 0)
            res = lists.get(0);
        
        for(int i = 1; i < lists.size(); i++){
            left = res;
            right = lists.get(i);
            res = null;
           
            while (left != null && right != null){
                if (left.val < right.val){
                    rem = left.next;
                    res = addToList(res,left);
                    left = rem;
                } else {
                    rem = right.next;
                    res = addToList(res,right);
                    right = rem;
                }
            }
            
            if (right != null)
                left = right;
                
            while (left != null){
                rem = left.next;
                res = addToList(res,left);
                left = rem;
            }
            
            if (res == null)
                break;
                
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
