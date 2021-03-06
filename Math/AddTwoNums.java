package Math;

import List.ListNode;

public class AddTwoNums {

	/*
	 * Add two numbers Use the node modification technique: check null + modify
	 * at parent level
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ListNode ans, upNode, downNode;

		upNode = l1;
		downNode = l2;
		int res, carry = 0;

		if (upNode == null) {
			upNode = l2;
			downNode = l1;
			ans = l2;
		} else {
			ans = l1;
		}

		if (ans == null)
			return ans;

		while (true) {
			res = upNode.val + carry;
			if (downNode != null)
				res += downNode.val;

			if (res >= 10) {
				carry = 1;
				res = res - 10;
			} else
				carry = 0;

			upNode.val = res;
			if (upNode.next == null && downNode != null) {
				upNode.next = downNode.next;
				downNode.next = null;
			}

			if (upNode.next == null) {
				if (carry > 0) {
					upNode.next = new ListNode(carry);
				}
				break;
			}

			upNode = upNode.next;
			if (downNode != null)
				downNode = downNode.next;
		}

		return ans;
	}
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        
        if (null == l1)
            l1 = l2;
            
        ListNode res = l1;
        
        while (null != l1){
            int sum = l1.val + carry;
            if (null != l2)
                sum += l2.val;
                
            if (sum >= 10){
                carry = sum / 10;
                sum %= 10;
            } else
                carry = 0;
            
            l1.val = sum;
            if (null == l1.next && null != l2){
                l1.next = l2.next;
                l2.next = null;
            }
            
            if (null == l1.next)
                break;
            else
                l1 = l1.next;
            
            if (null != l2)
                l2 = l2.next;
        }
        
        if (carry > 0)
            l1.next = new ListNode(carry);
            
        return res;
    }
	
	
	public void test() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);

		ListNode l2 = new ListNode(0);

		ListNode ans = addTwoNumbers(l1, l2);
		while (ans != null) {
			System.out.print(ans.val);
			ans = ans.next;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
