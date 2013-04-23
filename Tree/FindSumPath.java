package Tree;
public class FindSumPath {

	BST tree;
	int sum;
	
	public FindSumPath(BST t, int sum){
		tree = t;
		this.sum = sum;
	}
	
	private void findSum(BinTreeNode node, int[] path, int level){
		if (node == null)
			return;
		
		path[level] = node.val;
		
		int t = 0;
		for (int i = level; i >= 0; i--){
			t += path[i];
			if (t == sum)
				printPath(path, i,level);
		}
		
		findSum(node.leftChild,path,level+1);
		findSum(node.rightChild,path,level+1);
		
		path[level] = Integer.MIN_VALUE;
	}
	
	public void finding(){
		int[] path = new int[tree.getDepth()];
		findSum(tree.root,path,0);
	}
	
	private void printPath(int[] path, int start, int end){
		for(int i = start; i <= end; i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		FindSumPath fsp = new FindSumPath(bst, 5);
		bst.insertValue(2);
		bst.insertValue(3);
		bst.insertValue(-4);
		bst.insertValue(-2);
		bst.insertValue(6);
		
		fsp.finding();
	}

}
