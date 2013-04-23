package DataStructures;

import java.util.*;

public class PascalTriangle {

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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
