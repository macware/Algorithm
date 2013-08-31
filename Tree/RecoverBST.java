package Tree;

import java.util.*;

public class RecoverBST {

	private TreeNode t1, t2;

	/* This one is all the magic part */
	private void checkTriple(ArrayList<TreeNode> triple) {
		if (triple.size() == 1)
			return;
		if (triple.get(0).val > triple.get(1).val) {
			t2 = triple.get(1);
			if (t1 == null)
				t1 = triple.get(0);
		}

		triple.remove(0);
	}

	private void recoverHelper(TreeNode root, ArrayList<TreeNode> triple) {
		if (root == null)
			return;

		recoverHelper(root.left, triple);
		triple.add(root);
		if (triple.size() == 3)
			checkTriple(triple);
		recoverHelper(root.right, triple);

	}

	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		ArrayList<TreeNode> triple = new ArrayList<TreeNode>(3);
		t1 = t2 = null;
		recoverHelper(root, triple);
		checkTriple(triple);

		if (t1 != null && t2 != null) {
			int tmp = t1.val;
			t1.val = t2.val;
			t2.val = tmp;
		}
	}

	TreeNode prev;

	public void recovering(TreeNode root) {
		if (root == null)
			return;

		recovering(root.left);

		if (prev != null && prev.val > root.val) {
			if (t1 == null)
				t1 = prev;
			t2 = root;
		}

		prev = root;

		recovering(root.right);
	}

	public void recoverTree2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		prev = t1 = t2 = null;
		recovering(root);
		if (t1 != null && t2 != null) {
			int tmp = t1.val;
			t1.val = t2.val;
			t2.val = tmp;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
