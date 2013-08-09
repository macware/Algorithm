package Math;
/* Leetcode */
public class Division {

	private int neg(int a){
		int neg = 0;
		int d = a < 0? -1: 1;
		while (a != 0){
			neg += d;
			a += d;
		}
		
		return neg;
	}
	
	private int abs(int a){
		if (a < 0)
			return neg(a);
		else
			return a;
	}
	
	public int divide(int m, int n){
		int absm = abs(m);
		int absn = abs(n);
		
		if (absm < absn)
			return 0;
		
		int preRes = 0, res = 1;
		int preTotal = 0, total = absn;
		while (total < absm){
			preTotal = total;
			total += total;
			preRes = res;
			res += res;
		}
		
		if (total > absm){
			total = preTotal;
			res = preRes;
			while (total < absm){
				total += absn;
				res += 1;
			}
			
			if (total > absm)
				res -= 1;
		}
		
		if ((m^n) < 0){
			res = neg(res);
		}
		
		return res;
	}
	
	public int divide2(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        
        while ( a >= b){
            int i = 1;
            while ( a >= (b << i))
                i++;
            
            res |= (1 << (i-1));
            a -= (b << (i-1));
        }
        
        if (((dividend^divisor) >> 31) != 0)
            res = -res;
            
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Division div = new Division();
		//System.out.println(div.divide(10000, -23));
		System.out.println(div.divide2(10000, -23));
	}

}
