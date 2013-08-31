package Tree;
import java.util.*;

public class IsBST {

	public static TreeNode pre = null;

	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;

		if (!isValidBST(root.left))
			return false;

		if (pre != null && pre.val >= root.val)
			return false;

		pre = root;

		return isValidBST(root.right);
	}

	public boolean checking(TreeNode root, int min, int max){
        if (root == null)
            return true;
            
        if (!(root.val > min && root.val < max))
            return false;
            
        if (!checking(root.left,min,root.val))
            return false;
            
        return checking(root.right,root.val,max);
    }
    
    public boolean isValidBST2(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return checking(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST3(TreeNode root){
		Stack<TreeNode> path = new Stack<TreeNode>();
		TreeNode prev = null, cur = root;
		
		while (true){
			if (cur != null){
				path.push(cur);
				cur = cur.left;
			} else {
				if (path.isEmpty())
					break;
				
				cur = path.pop();
				if (prev != null && prev.val >= cur.val)
					return false;
				prev = cur;
				cur = cur.right;
			}
		}
				
		return true;
	}
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(0);
		TreeNode left = new TreeNode(-1);
		tree.left = left;
		IsBST isBST = new IsBST();
		System.out.println(isBST.isValidBST(tree));
	}

}
