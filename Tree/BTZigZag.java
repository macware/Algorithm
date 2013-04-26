package Tree;
import java.util.*;

public class BTZigZag {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (root == null)
            return res;
            
        ArrayList<TreeNode> cur, next;
        cur = new ArrayList<TreeNode>();
        cur.add(root);
        
        ArrayList<Integer> newList;
        boolean reverted = true;
        
        while (cur.size() != 0){
            next = new ArrayList<TreeNode>();
            newList = new ArrayList<Integer>();
            
            for (TreeNode node: cur){
                newList.add(node.val);
                
                if (reverted){
                    if (node.left != null)
                        next.add(0,node.left);
                    if (node.right != null)
                        next.add(0,node.right);
                } else {
                    if (node.right != null)
                        next.add(0,node.right);
                    if (node.left != null)
                        next.add(0,node.left);
                }
            }
            
            res.add(newList);
            cur = next;
            
            if (reverted)
                reverted = false;
            else
                reverted = true;
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
