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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
