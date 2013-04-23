package Tree;

public class IsBalanced {

	private int checkHeight(TreeNode root){
        if (root == null)
            return 0;
            
        int leftH = checkHeight(root.left);
        if (leftH == -2)
            return -2;
        
        int rightH = checkHeight(root.right);
        if (rightH == -2)
            return -2;
        
        if (Math.abs(rightH - leftH) > 1)
            return -2;
            
        return (1+Math.max(rightH,leftH));
    }
    
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return true;
            
        if (checkHeight(root) == -2)
            return false;
            
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
