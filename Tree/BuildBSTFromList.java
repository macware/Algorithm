package Tree;

import java.util.*;

import List.ListNode;

public class BuildBSTFromList {

	/* A global variable is needed to trace the current list node */
	private ListNode list;

	private TreeNode buildTree(int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode left = buildTree(start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		list = list.next;
		parent.left = left;
		if (list != null)
			parent.right = buildTree(mid + 1, end);

		return parent;
	}

	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;

		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		list = head;
		return buildTree(0, len - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ListNode> arr = new ArrayList<ListNode>();
		System.out.println(arr.size());
		arr.add(null);
		System.out.println(arr.size()+","+arr.get(0));

	}

}
