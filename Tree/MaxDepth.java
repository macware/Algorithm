package Tree;
import java.util.*;
public class MaxDepth {

	public int maxDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;

		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}

	public int maxDepth2(TreeNode root){
		int max = 0;
		if (root == null)
			return max;
		
		Stack<TreeNode> path = new Stack<TreeNode>();
		TreeNode cur = root;
		while (true){
			if (cur != null){
				path.add(cur);
				if (cur.left != null)
					cur = cur.left;
				else
					cur = cur.right;
			} else {
				max = Math.max(max, path.size());
				if (path.isEmpty())
					break;
				
				TreeNode tmp = path.pop();
				if (!path.isEmpty() && path.peek().left == tmp)
					cur = path.peek().right;
			}
		}
		
		return max;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
