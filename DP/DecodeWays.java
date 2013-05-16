package DP;

public class DecodeWays {

	public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0)
            return 0;
        
        int[] ways = new int[s.length()+1];
        ways[0] = 1;
        
        for(int i = 1; i <= s.length(); i++){
            ways[i] = 0;
            char c = s.charAt(i-1);
            
            // Consider itself
            if (c != '0')
                ways[i] = ways[i-1];
                
            // Combined with the previous one
            if (i > 1){
                char cprime = s.charAt(i-2);
                if (cprime == '1' || (cprime == '2' && c <= '6'))
                        ways[i] += ways[i-2];
            }
        }
        
        return ways[s.length()];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
