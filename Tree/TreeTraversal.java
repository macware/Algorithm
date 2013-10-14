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

	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		TreeNode p, pre = null, cur = root;
		while (true) {
			if (cur != null) {
				pre = cur;
				cur = cur.left;
				continue;
			}

			if (pre == null)
				break;

			res.add(pre.val);
			if (pre.right == null) {
				p = pre.parent;
				while (p != null && p.right == pre) {
					pre = p;
					p = pre.parent;
				}
				pre = p;
				if (pre == null)
					break;
				if (pre.right != null)
					res.add(pre.val);
			}

			cur = pre.right;
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

	public ArrayList<Integer> preorderTraversal2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode top, cur = root;
		while (true) {
			if (cur != null) {
				res.add(cur.val);
				stack.push(cur);
				cur = cur.left;
				continue;
			}

			if (stack.isEmpty())
				break;

			top = stack.pop();
			cur = top.right;
		}

		return res;
	}

	public ArrayList<Integer> preorderTraversal3(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		TreeNode p, pre = null, cur = root;
		while (true) {
			if (cur != null) {
				res.add(cur.val);
				pre = cur;
				if (cur.left != null)
					cur = cur.left;
				else
					cur = cur.right;
				continue;
			}

			if (pre == null)
				break;

			p = pre.parent;
			if (p != null && p.left == pre)
				cur = p.right;
			pre = p;
		}

		return res;
	}

	public ArrayList<Integer> preorderTraversal4(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		TreeNode p, pre = null, cur = root;
		while (true) {
			if (cur != null) {
				res.add(cur.val);
				pre = cur;
				cur = cur.left;
				continue;
			}

			if (pre == null)
				break;

			if (pre.right == null) {
				p = pre.parent;
				while (p != null && p.right == pre) {
					pre = p;
					p = pre.parent;
				}
				pre = p;
				if (pre == null)
					break;
			}

			cur = pre.right;
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

	public ArrayList<Integer> postorderTraversal3(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> path = new Stack<TreeNode>();
		TreeNode p, prev = null, cur = root;
		while (true) {
			if (cur != null) {
				prev = cur;
				path.push(cur);
				if (cur.left != null)
					cur = cur.left;
				else
					cur = cur.right;
			} else {
				if (prev == null)
					break;

				res.add(prev.val);
				p = prev.parent;
				if (p != null && p.left == prev)
					cur = p.right;
				prev = p;
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
		nodes[3].parent = nodes[4];
		nodes[5].parent = nodes[4];

		nodes[3].left = nodes[2];
		nodes[3].right = nodes[1];
		nodes[1].parent = nodes[3];
		nodes[2].parent = nodes[3];

		nodes[1].left = nodes[0];
		nodes[0].parent = nodes[1];

		nodes[5].left = nodes[6];
		nodes[5].right = nodes[7];
		nodes[6].parent = nodes[5];
		nodes[7].parent = nodes[5];

		nodes[7].right = nodes[8];
		nodes[8].parent = nodes[7];

		nodes[8].right = nodes[9];
		nodes[9].parent = nodes[8];

		TreeTraversal tt = new TreeTraversal();
		System.out.println(tt.inorderTraversal(nodes[4]));
		System.out.println(tt.inorderTraversal2(nodes[4]));

	}

}
