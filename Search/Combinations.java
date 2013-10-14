package Search;

import java.util.*;

public class Combinations {

	// order help reduce duplicates
	public void orderedDFS(int start, int n, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sol){
        int i;
        int count = n - start + 1;
        if (count == k || k == 0){
            ArrayList<Integer> newSol = new ArrayList<Integer>(sol);
            if (k != 0){
                for (i = start; i <= n; i++){
                    newSol.add(i);
                }
            }
            res.add(newSol);
            return;
        }
        
        for (i = start; i <= n; i++){
            count = n - i + 1;
            if (count < k)
                break;
            sol.add(i);
            orderedDFS(i+1, n, k-1, res, sol);
            sol.remove(sol.size()-1);
        }
        
        return;
    }
    
	public void combining(int depth, int n, int k, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        if (n - depth + 1 < k)
            return;
            
        if (n - depth + 1 == k || k == 0){
            ArrayList<Integer> item = new ArrayList<Integer>(path);
            if (k != 0){
                for (int i = depth; i <= n; i++)
                    item.add(i);
            }
            res.add(item);
            return;
        }
        
        for (int i = depth; i <= n; i++){
            if (n - i + 1 < k)
                break;
            path.add(i);
            combining(i+1,n,k-1,path,res);
            path.remove(path.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> combineDFS2(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0)
            return res;
            
        ArrayList<Integer> path = new ArrayList<Integer>();
        combining(1, n, k, path, res);
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (k <= 0 || k > n)
            return res;
            
        ArrayList<Integer> sol = new ArrayList<Integer>();
        orderedDFS(1, n, k, res, sol);
        
        return res;
    }
    
    public void combining_single(int depth, int n, int k, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        if (n - depth + 1 < k)
            return;
            
        if (n - depth + 1 == k || k == 0){
            ArrayList<Integer> item = new ArrayList<Integer>(path);
            if (k != 0){
                for (int i = depth; i <= n; i++)
                    item.add(i);
            }
            res.add(item);
            return;
        }
        
        // choose the depth
        path.add(depth);
        combining_single(depth+1, n, k-1, path, res);
        path.remove(path.size()-1);
        
        // skip the depth
        combining_single(depth+1, n, k, path, res);
    }
    
    public ArrayList<ArrayList<Integer>> combine_single(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0)
            return res;
            
        ArrayList<Integer> path = new ArrayList<Integer>();
        combining_single(1, n, k, path, res);
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
