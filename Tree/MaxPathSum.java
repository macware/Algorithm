package Tree;

public class MaxPathSum {

	private class IntWrapper {
        public int val;
        public IntWrapper(int v){
            val = v;
        }
    }
    
    public void getMax(TreeNode root, IntWrapper localMax, IntWrapper totalMax){
        if (root == null){
            localMax.val = 0;
            return;
        }
        
        IntWrapper leftMax, rightMax;
        leftMax = new IntWrapper(0);
        rightMax = new IntWrapper(0);
        
        getMax(root.left, leftMax, totalMax);
        getMax(root.right, rightMax, totalMax);
        
        localMax.val = Math.max(root.val, Math.max(root.val + leftMax.val, root.val + rightMax.val));
        totalMax.val = Math.max(totalMax.val, Math.max(localMax.val, root.val + leftMax.val + rightMax.val));
    }
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return 0;
            
        IntWrapper totalMax = new IntWrapper(Integer.MIN_VALUE);
        IntWrapper localMax = new IntWrapper(0);
        
        getMax(root, localMax, totalMax);
        
        return totalMax.val;
    }
    
    int maxSum = Integer.MIN_VALUE;
    public void findMax(TreeNode root, int preSum){
    	if (root == null)
    		return;
    	
    	int mySum = preSum + root.val;
    	if (mySum > maxSum)
    		maxSum = mySum;
    	
    	if (mySum < 0)
    		mySum = 0;
    	
    	findMax(root.left, mySum);
    	findMax(root.right, mySum);
    }
    
    public int maxSumInPath(TreeNode root){
    	if (root == null)
    		return 0;
    	
    	int preSum = 0;
    	maxSum = Integer.MIN_VALUE;
    	findMax(root,preSum);
    	
    	return maxSum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
