package DataStructures;

import java.util.*;

public class PascalTriangle {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0)
            return res;
            
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        res.add(pre);
        
        for (int i = 1; i < numRows; i++){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            
            for (int j = 1; j < pre.size(); j++)
                cur.add(pre.get(j-1) + pre.get(j));
            cur.add(1);
            
            res.add(cur);
            pre = cur;
        }
        
        return res;
    }
	
	public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (rowIndex < 0)
            return null;
            
        int[] res = new int[rowIndex+1];
        int[] newRes = new int[rowIndex+1];
        
        res[0] = 1;
        int i,j;
        for (i = 1; i <= rowIndex; i++){
            newRes[0] = 1;
            for (j = 1; j < rowIndex; j++){
                newRes[j] = res[j-1] + res[j];
            }
            newRes[j] = 1;
            
            int[] tmp = res;
            res = newRes;
            newRes = tmp;
        }
        
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (i = 0; i <= rowIndex; i++){
            ret.add(res[i]);
        }
        
        return ret;
    }
	
	/* 
	 * Roll back the array
	 */
	public ArrayList<Integer> getRow_best(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        
        int i,j,curlen;
        for(i = 0; i < rowIndex; i++){
            curlen = arr.size();
            arr.add(1);
            for (j = curlen - 1; j > 0; j--)
                arr.set(j, arr.get(j) + arr.get(j-1));
        }
        
        return arr;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
