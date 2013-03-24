package Tree;

import java.util.*;

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

		System.out.println(bst.rank(24));

		HashSet<Character> longestSub = new HashSet<Character>();

		HashSet<Character> newSub = new HashSet<Character>();
		longestSub.addAll(newSub);

	}

}
