package Tree;

public class ConvertDoublyLinkedList {

	public TreeNode concat(TreeNode l1, TreeNode l2){
		if (l1 == null)
			return l2;
		
		if (l2 == null)
			return l1;
		
		TreeNode head1 = l1, tail1 = l1.left;
		head1.left = null;
		tail1.right = null;
		
		TreeNode head2 = l2, tail2 = l2.left;
		head2.left = null;
		tail2.right = null;
		
		tail1.right = head2;
		head2.left = tail1;
		tail2.right = head1;
		head1.left = tail2;
		
		return head1;
	}
	
	public TreeNode converting(TreeNode root){
		if (root == null)
			return null;
		
		TreeNode left = converting(root.left);
		TreeNode right = converting(root.right);
		root.left = root.right = root;
		
		root = concat(left, root);
		root = concat(root, right);
		
		return root;		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
