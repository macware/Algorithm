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
    
    public int searchMax(TreeNode root, int[] maxSum){
        if (root == null)
            return 0;
            
        int leftmax = searchMax(root.left, maxSum);
        int rightmax = searchMax(root.right, maxSum);
        
        int ret = Math.max(root.val, root.val + Math.max(leftmax, rightmax));
        maxSum[0] = Math.max(maxSum[0], Math.max(ret, root.val + leftmax + rightmax));
        return ret;
    }
    
    public int maxPathSum2(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return 0;
            
        int[] maxSum = new int[0];
        maxSum[0] = Integer.MIN_VALUE;
        searchMax(root, maxSum);
        
        return maxSum[0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
