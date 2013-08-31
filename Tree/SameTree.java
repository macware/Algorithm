package Tree;

import java.util.*;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		boolean res = isSameTree(p.left, q.left);
		if (!res)
			return false;

		if (p.val != q.val)
			return false;

		return isSameTree(p.right, q.right);
	}

	public boolean isSameTree2(TreeNode p, TreeNode q) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p == null && q == null)
			return true;

		if (p == null || q == null || p.val != q.val)
			return false;

		Queue<TreeNode> pqueue = new ArrayDeque<TreeNode>();
		Queue<TreeNode> qqueue = new ArrayDeque<TreeNode>();

		pqueue.add(p);
		qqueue.add(q);

		while (!pqueue.isEmpty() && !qqueue.isEmpty()) {
			TreeNode pn = pqueue.remove();
			TreeNode qn = qqueue.remove();

			if (pn.left != null && qn.left != null
					&& qn.left.val == pn.left.val) {
				pqueue.add(pn.left);
				qqueue.add(qn.left);
			} else if (!(pn.left == null && qn.left == null))
				return false;

			if (pn.right != null && qn.right != null
					&& pn.right.val == qn.right.val) {
				pqueue.add(pn.right);
				qqueue.add(qn.right);
			} else if (!(pn.right == null && qn.right == null))
				return false;
		}

		return (pqueue.isEmpty() && qqueue.isEmpty());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p = new TreeNode(0);
		TreeNode q = new TreeNode(1);
		SameTree st = new SameTree();
		System.out.println(st.isSameTree2(p, q));
	}

}
