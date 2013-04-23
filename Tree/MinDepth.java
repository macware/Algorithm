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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
