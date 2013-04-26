package Search;

public class BeatStock {

	/* At most two transactions -- Divide and conquer */
	public int maxProfit_ver3(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length == 0)
            return 0;
            
        int[] forward = new int[prices.length];
        int[] backward = new int[prices.length];
        
        int i,n,maxProfit = 0;
        
        n = prices[0];
        forward[0] = 0;
        for (i = 1; i < prices.length; i++){
            n = Math.min(n,prices[i]);
            forward[i] = Math.max(forward[i-1],prices[i] - n);
        }
        
        n = prices[prices.length-1];
        backward[prices.length-1] = 0;
        for (i = prices.length - 2; i >= 0; i--){
            n = Math.max(n,prices[i]);
            backward[i] = Math.max(backward[i+1],n - prices[i]);
            maxProfit = Math.max(maxProfit, forward[i] + backward[i]);
        }
        
        return maxProfit;   
    }
	
	/* Multiple transactions but must sell one stock before buying */
	public int maxProfit_ver2(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null)
            return 0;
        
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] - prices[i-1] > 0)
                profit += prices[i] - prices[i-1];
        }
        
        return profit;
    }
	
	/* At most one transaction */
	public int maxProfit_ver1(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null)
        	return 0;
        
        int low = Integer.MAX_VALUE, profit = 0;
        for (int i = 0; i < prices.length; i++){
        	low = Math.min(prices[i], low);
        	profit = Math.max(prices[i] - low, profit);
        }
        
        return profit;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
