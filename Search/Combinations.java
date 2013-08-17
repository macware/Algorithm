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
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
