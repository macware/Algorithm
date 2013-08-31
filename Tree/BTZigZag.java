package Tree;

import java.util.*;

public class BTZigZag {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if (root == null)
			return res;

		ArrayList<TreeNode> cur, next;
		cur = new ArrayList<TreeNode>();
		cur.add(root);

		ArrayList<Integer> newList;
		boolean reverted = true;

		while (cur.size() != 0) {
			next = new ArrayList<TreeNode>();
			newList = new ArrayList<Integer>();

			for (TreeNode node : cur) {
				newList.add(node.val);

				if (reverted) {
					if (node.left != null)
						next.add(0, node.left);
					if (node.right != null)
						next.add(0, node.right);
				} else {
					if (node.right != null)
						next.add(0, node.right);
					if (node.left != null)
						next.add(0, node.left);
				}
			}

			res.add(newList);
			cur = next;

			if (reverted)
				reverted = false;
			else
				reverted = true;
		}

		return res;
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;

		boolean odd = false;
		Stack<TreeNode> pre = new Stack<TreeNode>();
		Stack<TreeNode> cur = new Stack<TreeNode>();

		pre.push(root);
		while (!pre.isEmpty()) {
			ArrayList<Integer> item = new ArrayList<Integer>();

			while (!pre.isEmpty()) {
				TreeNode n = pre.pop();
				item.add(n.val);

				if (odd) {
					if (n.right != null)
						cur.push(n.right);
					if (n.left != null)
						cur.push(n.left);
				} else {
					if (n.left != null)
						cur.push(n.left);
					if (n.right != null)
						cur.push(n.right);
				}
			}

			odd = !odd;
			res.add(item);

			Stack<TreeNode> tmp = cur;
			cur = pre;
			pre = tmp;
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
