package Tree;

public class NextRightPointer {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect_iterative(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeLinkNode leftWall = root;
		TreeLinkNode cross;

		while (leftWall != null) {
			cross = leftWall;
			while (cross != null) {
				if (cross.left != null)
					cross.left.next = cross.right;
				if (cross.right != null && cross.next != null)
					cross.right.next = cross.next.left;
				cross = cross.next;
			}
			leftWall = leftWall.left;
		}
	}

	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			return;

		TreeLinkNode p = root;
		while (p != null) {
			p.left.next = p.right;
			if (p.next != null)
				p.right.next = p.next.left;
			p = p.next;
		}

		connect(root.left);
	}

	/*
	 * BFS is OK. But what we really need is to record the previous node and the
	 * next node. So a list for the nodes in each layer is redundant. As long as
	 * we can traverse the node in each layer, two typical pointers are enough.
	 */
	public void connect_general(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;

		TreeLinkNode cur, next, nextRoot;
		TreeLinkNode p = root;
		cur = next = nextRoot = null;

		while (cur == null) {
			if (p == null)
				break;
			cur = p.left;
			if (cur != null)
				next = p.right;
			else
				cur = p.right;
			p = p.next;
		}

		nextRoot = cur;

		if (next != null) {
			cur.next = next;
			cur = next;
		}

		while (p != null) {
			next = p.left;
			if (next != null) {
				cur.next = next;
				cur = next;
			}

			next = p.right;
			if (next != null) {
				cur.next = next;
				cur = next;
			}

			p = p.next;
		}

		connect(nextRoot);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
