package Tree;

public class FindCommonAncestor {

	private BST tree;
	public FindCommonAncestor(BST bst){
		tree = bst;
	}
	
	class Result{
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc){
			node = n;
			isAncestor = isAnc;
		}
	}
	
	private Result commonAncestorHelper(TreeNode node, TreeNode p, TreeNode q){
		if (node == null)
			return new Result(null,false);
		
		if (node == p && node == q)
			return new Result(node,true);
		
		Result rx = commonAncestorHelper(node.left, p, q);
		if (rx.isAncestor)
			return rx;
		
		Result ry = commonAncestorHelper(node.right, p, q);
		if (ry.isAncestor)
			return ry;
		
		if (rx.node != null && ry.node != null)
			return new Result(node,true);
		else if (node == p || node == q){
			boolean isAnc = rx.node != null || ry.node != null ? true: false;
			return new Result(node,isAnc);
		} else {
			if (rx.node != null)
				return rx;
			else
				return ry;
		}
	}
	
	public TreeNode finding(TreeNode p, TreeNode q){
		Result r = commonAncestorHelper(tree.root, p, q);
		if (r.isAncestor)
			return r.node;
		else
			return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
