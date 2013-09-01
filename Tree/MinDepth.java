package Tree;

import java.util.*;

public class MinDepth {

	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		ArrayList<TreeNode> cur, next;
		cur = new ArrayList<TreeNode>();
		cur.add(root);

		int minDep = 0;
		while (cur.size() != 0) {
			minDep++;
			next = new ArrayList<TreeNode>();
			for (int i = 0; i < cur.size(); i++) {
				TreeNode node = cur.get(i);
				if (node.left == null && node.right == null)
					return minDep;
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
			}

			cur = next;
		}

		return minDep;
	}

	/*
	 * null as a delimiter between different levels
	 */
	public int minDepth2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;

		int len = 0;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		que.add(null);

		while (true) {
			TreeNode n = que.remove();
			if (n == null) {
				len++;
				if (que.isEmpty())
					break;
				que.add(null);
			} else {
				if (n.left == null && n.right == null)
					return (len + 1);
				if (n.left != null)
					que.add(n.left);
				if (n.right != null)
					que.add(n.right);
			}
		}

		return len;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
