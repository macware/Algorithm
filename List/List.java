package List;

public class List {
	private ListNode head;
	private ListNode end;
	
	public List(){
		head = new ListNode(0);
		end = null;
	}
	
	public ListNode getStart(){
		return head.next;
	}
	
	public ListNode getEnd(){
		return end;
	}
	
	public ListNode getNode(int ith){
		ListNode cur = head.next;
		int n = ith - 1;
		while (n > 0 && cur != null){
			n--;
			cur = cur.next;
		}
		
		return cur;
	}
	
	public void appendNode(int d){
		ListNode node = new ListNode(d);
		ListNode cur = head;
		
		while (cur.next != null){
			cur = cur.next;
		}
		
		cur.next = node;
		end = node;
	}
	
	public void deleteNode(int d){
		ListNode cur = head;
		
		while (cur.next.data != d){
			cur = cur.next;
		}
		
		ListNode node = cur.next;
		cur.next = node.next;
		if (node == end)
			end = cur;
	}
	
	public void printList(){
		ListNode cur = head.next;
		
		while( cur != null){
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
	}
}
