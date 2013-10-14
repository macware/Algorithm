package Tree;
import java.util.*;

// Binary Search Tree
public class BST {

	public TreeNode root;

	public void insertValue(int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else {
			insert(root, root, val);
		}
	}

	private TreeNode insert(TreeNode parent, TreeNode node, int val) {
		// add a new node
		if (node == null) {
			TreeNode newNode = new TreeNode(val);
			newNode.parent = parent;
			return newNode;
		}

		if (node.val > val)
			node.left = insert(node, node.left, val);
		else
			node.right = insert(node, node.right, val);

		// increase the number of nodes rooted at the node
		node.size++;
		return node;
	}

	public void inorderPrint(){
		if (root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode top, cur = root;
		while (true){
			if (cur != null){
				stack.push(cur);
				cur = cur.left;
				continue;
			}
			
			if (stack.isEmpty())
				break;
			top = stack.pop();
			System.out.print(top.val +" ");
			cur = top.right;
		}
		
		System.out.println();
	}
	
	// get the rank of the value (exclusively)
	private int counter;
	private TreeNode target;
	public int rank(int val) {
		if (root == null)
			return -1;

		// check the root first
		if (root.val == val){
			counter = root.size - root.right.size - 1;
			return counter;
		}
		
		// traverse its children
		if ((root.val < val) && (root.right != null)) {
			counter = root.size - root.right.size;
			ranking(root.right, val);
		} else {
			counter = 0;
			ranking(root.left, val);
		}

		if(target == null)
			counter = -1;
		
		return counter;
	}

	private void ranking(TreeNode node, int val) {
		if (node == null)
			return;

		if (node.val == val){
			target = node;
			return;
		}
		
		if ((node.val < val) && (node.right != null)) {
			counter += node.size - node.right.size;
			ranking(node.right, val);
		} else {
			ranking(node.left, val);
		}
	}
	
	public int getDepth(){
		return depthHelper(root);
	}
	
	private int depthHelper(TreeNode node){
		if (node == null)
			return 0;
		else
			return 1 + Math.max(depthHelper(node.left), depthHelper(node.right));
	}
}
