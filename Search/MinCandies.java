package Search;

public class MinCandies {

	public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (ratings == null || ratings.length == 0)
            return 0;
            
        int n = ratings.length;
        int[] mores = new int[n];
        int i, more = 1;
        
        for (i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i-1])
                mores[i] = Math.max(more++, mores[i]);
            else
                more=1;
        }
        
        more = 1;
        for (i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i+1])
                mores[i] = Math.max(more++, mores[i]);
            else
                more = 1;
        }
        
        for (i = 0; i < ratings.length; i++)
            n += mores[i];
            
        return n;
    }
	
	// Wrong answer 14 vs 13 for [1,3,4,3,2,1]
	public int candy2(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (ratings == null || ratings.length == 0)
            return 0;
            
        int n = ratings.length;
        int[] mores = new int[n];
        int i, more = 1;
        
        for (i = 0; i < ratings.length - 1; i++){
            if (ratings[i] > ratings[i+1])
                mores[i] = Math.max(more++, mores[i]);
            else
                more=1;
        }
        
        more = 1;
        for (i = ratings.length - 1; i > 0; i--){
            if (ratings[i] > ratings[i-1])
                mores[i] = Math.max(more++, mores[i]);
            else
                more = 1;
        }
        
        for (i = 0; i < ratings.length; i++)
            n += mores[i];
            
        return n;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
