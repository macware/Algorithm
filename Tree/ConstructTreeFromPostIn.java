package Tree;

public class ConstructTreeFromPostIn {

	/*
	 * The valid length for the left part in postorder is one less than that in
	 * preorder
	 */
	public TreeNode building(int[] inorder, int is, int ie, int[] postorder,
			int ps, int pe) {
		if (is > ie || ps > pe)
			return null;

		TreeNode root = new TreeNode(postorder[pe]);

		int i, len;
		for (i = is; i <= ie; i++) {
			if (inorder[i] == postorder[pe])
				break;
		}

		len = i - is;

		root.left = building(inorder, is, i - 1, postorder, ps, ps + len - 1);
		root.right = building(inorder, i + 1, ie, postorder, ps + len, pe - 1);

		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (inorder.length != postorder.length)
			return null;

		return building(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructTreeFromPostIn ctfpi = new ConstructTreeFromPostIn();
		TreeNode root = ctfpi.buildTree(new int[] { 1, 2 }, new int[] { 2, 1 });
		System.out.println(root.right.val);
	}

}
