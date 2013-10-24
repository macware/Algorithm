package Tree;

public class TreeOps {
	
	public void insert_recur(TreeNode root, int val){
		if (root == null)
			return;
		
		if (root.val <= val){
			if (root.right == null)
				root.right = new TreeNode(val);
			else
				insert_recur(root.right,val);
		} else {
			if (root.left == null)
				root.left = new TreeNode(val);
			else
				insert_recur(root.left, val);
		}
	}
	
	public TreeNode insert_iter(TreeNode root, int val){
		if (root == null)
			return new TreeNode(val);
		
		TreeNode p = null, cur = root;
		while (cur != null){
			p = cur;
			if (cur.val <= val)
				cur = cur.right;
			else
				cur = cur.left;
		}
		
		if (p.val <= val)
			p.right = new TreeNode(val);
		else
			p.left = new TreeNode(val);
		
		return root;
	}	
	
	public void delete(TreeNode cur, TreeNode p, int val){
		if (cur == null)
			return;
		
		if (cur.val < val)
			delete(cur.right,cur,val);
		else if (cur.val > val)
			delete(cur.left, cur, val);
		
		if (cur.val != val)
			return;
		
		if (cur.left == null){
			if (p.val > val)
				p.left = cur.right;
			else
				p.right = cur.right;
			return;
		}
		
		if (cur.right == null){
			if (p.val > val)
				p.left = cur.left;
			else
				p.right = cur.left;
			return;
		}
		
		TreeNode parent = cur;
		TreeNode next = cur.right;
		while (next.left != null){
			parent = next;
			next = next.left;
		}
		
		cur.val = next.val;
		// You still have to check here
		if (parent.val > next.val)
			parent.left = next.right;
		else
			parent.right = next.right;
	}
	public TreeNode delete_recur(TreeNode root, int val){
		if (root == null)
			return null;
		
		if (root.val == val){
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
		}
		
		delete(root,null,val);
		return root;
	}
	
	public TreeNode delete_iter(TreeNode root, int val){
		if (root == null)
			return null;
		if (root.val == val){
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
		}
		
		TreeNode p = null, cur = root;
		while (cur != null && cur.val != val){
			p = cur;
			if (cur.val < val)
				cur = cur.right;
			else
				cur = cur.left;
		}
		
		if (cur == null)
			return root;
		
		if (cur.left == null){
			if (p.val > val)
				p.left = cur.right;
			else
				p.right = cur.right;
		} else if (cur.right == null){
			if (p.val > val)
				p.left = cur.left;
			else
				p.right = cur.left;
		} else {
			p = cur;
			TreeNode next = cur.right;
			while (next.left != null){
				p = next;
				next = next.left;
			}
			
			cur.val = next.val;
			if (p.val > next.val)
				p.left = next.right;
			else
				p.right = next.right;
		}
		
		return root;
	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
