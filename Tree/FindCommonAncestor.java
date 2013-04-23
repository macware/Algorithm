package Tree;

public class FindCommonAncestor {

	private BST tree;
	public FindCommonAncestor(BST bst){
		tree = bst;
	}
	
	class Result{
		public BinTreeNode node;
		public boolean isAncestor;
		public Result(BinTreeNode n, boolean isAnc){
			node = n;
			isAncestor = isAnc;
		}
	}
	
	private Result commonAncestorHelper(BinTreeNode node, BinTreeNode p, BinTreeNode q){
		if (node == null)
			return new Result(null,false);
		
		if (node == p && node == q)
			return new Result(node,true);
		
		Result rx = commonAncestorHelper(node.leftChild, p, q);
		if (rx.isAncestor)
			return rx;
		
		Result ry = commonAncestorHelper(node.rightChild, p, q);
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
	
	public BinTreeNode finding(BinTreeNode p, BinTreeNode q){
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
