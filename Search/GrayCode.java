package Search;
import java.util.*;

public class GrayCode {

	/*
	 * Mirroring will reflect and keep the change
	 */
	public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n < 0)
        	return res;
        
        res.add(0);
        
        int i,j,k;
        for (i = 0; i < n; i++){
        	for (j = res.size() - 1; j >= 0; j--){
        		k = (res.get(j) | (1 << i));
        		res.add(k);
        	}
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(0));
	}

}
