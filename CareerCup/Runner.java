package CareerCup;
import List.*;

// Chapter 2, this is a really good and useful technique
public class Runner {
	private List loopedList;
	
	public Runner(){
		
	}
	
	public Runner(int len, int i){
		loopedList = new List();
		for (int k = 0; k < len; k++){
			loopedList.appendNode(k);
		}
		loopedList.getEnd().next = loopedList.getNode(i);
	}
	
	public ListNode findLoopRoot(List l){
		if (l != null)
			loopedList = l;
		
		if (loopedList == null)
			return null;
		
		ListNode slow = loopedList.getStart();
		ListNode fast = slow;
		
		// we need to make sure we can access the fast.next
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			// collision, k steps behind the loop root
			if (slow == fast)
				break;
		}
		
		// error check, no meeting point
		if (fast == null || fast.next == null)
			return null;
		
		slow = loopedList.getStart();
		while (slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner r = new Runner(20,8);
		System.out.println(r.findLoopRoot(null).data);
	}

}
