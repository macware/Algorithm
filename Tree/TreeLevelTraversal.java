package Tree;

import java.util.*;

public class TreeLevelTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;

		Queue<TreeNode> pre = new LinkedList<TreeNode>();
		Queue<TreeNode> cur = new LinkedList<TreeNode>();

		pre.add(root);
		while (!pre.isEmpty()) {
			ArrayList<Integer> item = new ArrayList<Integer>();

			while (!pre.isEmpty()) {
				TreeNode n = pre.remove();
				item.add(n.val);
				
				if (n.left != null)
					cur.add(n.left);
				if (n.right != null)
					cur.add(n.right);
			}

			res.add(item);
			Queue<TreeNode> tmp = cur;
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
