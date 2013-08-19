package Search;

import java.util.*;

public class Subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        
        if (S == null || S.length == 0)
            return res;
            
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++){
            if (i > 0 && S[i] == S[i-1])
                continue;
                
            ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> item: res){
                ArrayList<Integer> newItem = new ArrayList<Integer>(item);
                newItem.add(S[i]);
                newRes.add(newItem);
            }
            
            res.addAll(newRes);
        }
        
        return res;
    }
	
	/**
	 * Sorting and compare can help deal with duplicates
	 * @param start
	 * @param S
	 * @param res
	 * @param sol
	 */
	public void dfs(int start, int[] S, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sol){
        res.add(new ArrayList<Integer>(sol));
        
        for (int i = start; i < S.length; i++){
            if (i > start && S[i] == S[i-1])
                continue;
                
            sol.add(S[i]);
            dfs(i+1, S, res, sol);
            sol.remove(sol.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (S == null || S.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
            
        Arrays.sort(S);
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(0, S, res, sol);
        
        return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
