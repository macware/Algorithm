package Tree;

import java.util.*;

public class TreeTraversal {

	/*
	 * cur simulates the current recursion node
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> path = new Stack<TreeNode>();
		TreeNode cur = root;
		while (true) {
			if (cur != null) {
				path.push(cur);
				cur = cur.left;
			} else {
				if (path.isEmpty())
					break;

				cur = path.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}

		return res;
	}

	/*
	 * intuitively, make sure the left node be popped out first
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			res.add(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}

		return res;
	}

	/*
	 * When pre == cur, the subtree rooted at cur has been traversed
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> path = new Stack<TreeNode>();
		TreeNode prev = null, cur;
		path.push(root);
		while (!path.isEmpty()) {
			cur = path.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null)
					path.push(cur.left);
				else if (cur.right != null)
					path.push(cur.right);
			} else if (cur.left == prev) {
				if (cur.right != null)
					path.push(cur.right);
			} else {
				res.add(cur.val);
				path.pop();
			}
			prev = cur;
		}

		return res;
	}

	public ArrayList<Integer> postorderTraversal2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> path = new Stack<TreeNode>();
		TreeNode tmp, cur = root;
		while (true) {
			if (cur != null) {
				path.push(cur);
				if (cur.left != null)
					cur = cur.left;
				else
					cur = cur.right;
			} else {
				if (path.isEmpty())
					break;

				tmp = path.pop();
				res.add(tmp.val);
				if (!path.isEmpty() && path.peek().left == tmp)
					cur = path.peek().right;
			}
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode[] nodes = new TreeNode[10];
		for (int i = 0; i < nodes.length; i++)
			nodes[i] = new TreeNode(i);
		
		nodes[4].left = nodes[3];
		nodes[4].right = nodes[5];
		nodes[3].left = nodes[2];
		nodes[3].right = nodes[1];
		nodes[1].left = nodes[0];
		
		nodes[5].left = nodes[6];
		nodes[5].right = nodes[7];
		nodes[7].right = nodes[8];
		nodes[8].right = nodes[9];
		
		TreeTraversal tt = new TreeTraversal();
		System.out.println(tt.postorderTraversal2(nodes[4]));
		
	}

}
