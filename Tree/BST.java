package Tree;

import java.math.*;

// Binary Search Tree
public class BST {

	public BinTreeNode root;

	public void insertValue(int val) {
		if (root == null) {
			root = new BinTreeNode(val);
		} else {
			insert(root, root, val);
		}
	}

	private BinTreeNode insert(BinTreeNode parent, BinTreeNode node, int val) {
		// add a new node
		if (node == null) {
			BinTreeNode newNode = new BinTreeNode(val);
			newNode.parent = parent;
			return newNode;
		}

		if (node.val > val)
			node.leftChild = insert(node, node.leftChild, val);
		else
			node.rightChild = insert(node, node.rightChild, val);

		// increase the number of nodes rooted at the node
		node.size++;
		return node;
	}

	// get the rank of the value (exclusively)
	private int counter;
	private BinTreeNode target;
	public int rank(int val) {
		if (root == null)
			return -1;

		// check the root first
		if (root.val == val){
			counter = root.size - root.rightChild.size - 1;
			return counter;
		}
		
		// traverse its children
		if ((root.val < val) && (root.rightChild != null)) {
			counter = root.size - root.rightChild.size;
			ranking(root.rightChild, val);
		} else {
			counter = 0;
			ranking(root.leftChild, val);
		}

		if(target == null)
			counter = -1;
		
		return counter;
	}

	private void ranking(BinTreeNode node, int val) {
		if (node == null)
			return;

		if (node.val == val){
			target = node;
			return;
		}
		
		if ((node.val < val) && (node.rightChild != null)) {
			counter += node.size - node.rightChild.size;
			ranking(node.rightChild, val);
		} else {
			ranking(node.leftChild, val);
		}
	}
	
	public int getDepth(){
		return depthHelper(root);
	}
	
	private int depthHelper(BinTreeNode node){
		if (node == null)
			return 0;
		else
			return 1 + Math.max(depthHelper(node.leftChild), depthHelper(node.rightChild));
	}
}
