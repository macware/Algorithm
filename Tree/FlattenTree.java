package Tree;

public class FlattenTree {

	private TreeNode tail;

	private void flattenHelper(TreeNode node) {
		if (node == null)
			return;

		tail.right = node;

		TreeNode left = node.left;
		TreeNode right = node.right;

		node.left = null;
		tail = node;

		flattenHelper(left);
		flattenHelper(right);
	}

	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = null;
		tail = root;

		flattenHelper(left);
		flattenHelper(right);
	}

	public void flating(TreeNode root) {
		if (root == null)
			return;

		if (tail != null)
			tail.right = root;

		tail = root;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;

		flating(left);
		flating(right);
	}

	public void flatten2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		tail = null;
		flating(root);
	}

	/*
	 * Put the right subtree to the rightmost leaf of the left subtree, matching
	 * the semantic of preorder search
	 */
	public void flatten3(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeNode next, cur = root;
		while (cur != null) {
			if (cur.left != null) {
				if (cur.right != null) {
					next = cur.left;
					while (next.right != null)
						next = next.right;
					next.right = cur.right;
				}

				cur.right = cur.left;
				cur.left = null;
			}

			cur = cur.right;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
