package Search;

import java.util.*;

public class LongestConsecSeq {

	public int expand(HashSet<Integer> set, int start, int dir){
		int count = 0;
		int next = start + dir;
		while (set.contains(next)){
			count++;
			set.remove(next);
			next += dir;
		}
		
		return count;
	}
	
	public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (num == null)
			return 0;
		
        int newMax = 0, max = 0;
        int i;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (i = 0; i < num.length; i++)
        	set.add(num[i]);
        
        for (i = 0; i < num.length; i++){
        	newMax = 1;
        	if (set.contains(num[i])){
        		set.remove(num[i]);
        		newMax = newMax + expand(set,num[i],-1) + expand(set,num[i],1);     		
        	}
        	max = Math.max(max, newMax);
        }
        
        return max;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecSeq lconse = new LongestConsecSeq();
		System.out.println(lconse.longestConsecutive(new int[]{100,4,200,1,3,2}));
	}

}
