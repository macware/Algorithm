package Tree;

public class BinTreeNode {
	public BinTreeNode parent;
	public BinTreeNode leftChild;
	public BinTreeNode rightChild;
	
	public int val;
	
	// the number of nodes rooted at current node
	public int size = 1;
	
	public BinTreeNode(){		
	}
	
	public BinTreeNode(int v){		
		val = v;
	}
	
	public BinTreeNode(BinTreeNode p, BinTreeNode l, BinTreeNode r){
		parent = p;
		leftChild = l;
		rightChild = r;
	}
}
