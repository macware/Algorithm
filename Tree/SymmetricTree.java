package Tree;

public class SymmetricTree {

	private boolean symHelper(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return (symHelper(t1.left,t2.right) && (symHelper(t1.right,t2.left)));
    }
    
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return true;
            
        return symHelper(root.left,root.right);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
