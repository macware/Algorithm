package Tree;
import java.util.*;
public class SymmetricTree {

	private boolean symHelper(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		if (t1.val != t2.val)
			return false;
		return (symHelper(t1.left, t2.right) && (symHelper(t1.right, t2.left)));
	}

	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;

		return symHelper(root.left, root.right);
	}

	public boolean checking(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;

		if (p == null || q == null || p.val != q.val)
			return false;

		Queue<TreeNode> pque = new ArrayDeque<TreeNode>();
		Queue<TreeNode> qque = new ArrayDeque<TreeNode>();

		pque.add(p);
		qque.add(q);

		while (!pque.isEmpty() && !qque.isEmpty()) {
			TreeNode pn = pque.remove();
			TreeNode qn = qque.remove();

			if (pn.left != null && qn.right != null
					&& pn.left.val == qn.right.val) {
				pque.add(pn.left);
				qque.add(qn.right);
			} else if (!(pn.left == null && qn.right == null))
				return false;

			if (pn.right != null && qn.left != null
					&& pn.right.val == qn.left.val) {
				pque.add(pn.right);
				qque.add(qn.left);
			} else if (!(pn.right == null && qn.left == null))
				return false;
		}

		return (pque.isEmpty() && qque.isEmpty());
	}

	public boolean isSymmetric2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return (root == null || checking(root.left, root.right));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
