package Tree;

import java.util.*;

public class PathSum {

	/*
	 * Leaf specific checking requires checking from parent
	 */
	public boolean checking(TreeNode root, int sum, int tmp) {
		if (root.left == null && root.right == null)
			return (sum == tmp);

		if (root.left != null && checking(root.left, sum, tmp + root.left.val))
			return true;

		if (root.right != null
				&& checking(root.right, sum, tmp + root.right.val))
			return true;

		return false;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return false;

		return checking(root, sum, root.val);
	}

	public void finding(TreeNode root, int sum, int tmp,
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sol) {
		if (root.left == null && root.right == null && sum == tmp) {
			res.add(new ArrayList<Integer>(sol));
			return;
		}

		if (root.left != null) {
			sol.add(root.left.val);
			finding(root.left, sum, tmp + root.left.val, res, sol);
			sol.remove(sol.size() - 1);
		}

		if (root.right != null) {
			sol.add(root.right.val);
			finding(root.right, sum, tmp + root.right.val, res, sol);
			sol.remove(sol.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;

		ArrayList<Integer> sol = new ArrayList<Integer>();
		sol.add(root.val);

		finding(root, sum, root.val, res, sol);

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
