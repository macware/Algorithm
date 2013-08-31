package Tree;

import java.util.*;

public class UniqueBSTs {

	/*
	 * Similar to fib array. f(n) = sum(i=1..n)(f(i-1)*f(n-i)); f(0) = f(1) = 1;
	 */
	public int numTreesHelper(int n, int[] cache) {
		if (n <= 1)
			return 1;
		if (cache[n] != 0)
			return cache[n];

		int ret = 0;
		for (int i = 1; i <= n; i++) {
			ret += numTreesHelper(i - 1, cache) * numTreesHelper(n - i, cache);
		}

		cache[n] = ret;
		return ret;
	}

	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 0)
			return 0;

		if (n <= 1)
			return 1;

		int[] cache = new int[n + 1];
		return numTreesHelper(n, cache);
	}

	/*
	 * DP from bottom up
	 */
	public int numTrees2(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0)
            return 0;
            
        int[] tmp = new int[n+1];
        tmp[0] = tmp[1] = 1;
        
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++)
                tmp[i] += (tmp[j-1] * tmp[i-j]);
        }
        
        return tmp[n];
    }
	
	public ArrayList<TreeNode> generating(int s, int e){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (s > e){
            res.add(null);
            return res;
        }
        
        for (int i = s; i <= e; i++){
            ArrayList<TreeNode> lefts = generating(s, i-1);
            ArrayList<TreeNode> rights = generating(i+1, e);
            for (TreeNode lnode : lefts){
                for (TreeNode rnode : rights){
                    TreeNode node = new TreeNode(i);
                    node.left = lnode;
                    node.right = rnode;
                    res.add(node);
                }
            }           
        }
        
        return res;
    }
    
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generating(1,n);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
