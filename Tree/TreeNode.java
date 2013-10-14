package Tree;

public class TreeNode {
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	
	public int val;
	
	// the number of nodes rooted at current node
	public int size = 1;
	
	public TreeNode(){		
	}
	
	public TreeNode(int v){		
		val = v;
	}
	
	public TreeNode(TreeNode p, TreeNode l, TreeNode r){
		parent = p;
		left = l;
		right = r;
	}
}
