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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Division div = new Division();
		System.out.println(div.divide(10000, -23));
	}

}
