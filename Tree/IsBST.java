package Tree;

public class IsBST {

	public static TreeNode pre = null;

	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;

		if (!isValidBST(root.left))
			return false;

		if (pre != null && pre.val >= root.val)
			return false;

		pre = root;

		return isValidBST(root.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(0);
		TreeNode left = new TreeNode(-1);
		tree.left = left;
		IsBST isBST = new IsBST();
		System.out.println(isBST.isValidBST(tree));
	}

}
