package Tree;

public class ConstructTreeFromPreIn {

	/*
	 * index is really tricky
	 */
	public TreeNode building(int[] preorder, int ps, int pe, int[] inorder,
			int is, int ie) {
		if (ps > pe || is > ie)
			return null;

		TreeNode root = new TreeNode(preorder[ps]);
		int i, len;
		for (i = is; i <= ie; i++) {
			if (inorder[i] == preorder[ps])
				break;
		}
		len = i - is + 1;

		root.left = building(preorder, ps + 1, ps + len - 1, inorder, is, i - 1);
		root.right = building(preorder, ps + len, pe, inorder, i + 1, ie);

		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (preorder.length != inorder.length)
			return null;

		return building(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
