package Tree;

public class TestTrees {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();

		// we have to assume the tree is balanced
		bst.insertValue(20);
		bst.insertValue(15);
		bst.insertValue(10);
		bst.insertValue(5);
		bst.insertValue(13);
		bst.insertValue(25);
		bst.insertValue(23);
		bst.insertValue(24);

		bst.inorderPrint();
		
		ConvertDoublyLinkedList cdll = new ConvertDoublyLinkedList();
		TreeNode t = cdll.converting(bst.root);
		if (t == null)
			return;
		
		TreeNode cur = t;
		System.out.print(t.val +" ");
		while (cur.right != t){
			System.out.print(cur.right.val+" ");
			cur = cur.right;
		}

	}

}
