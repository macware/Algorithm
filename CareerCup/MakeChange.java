package CareerCup;

public class MakeChange {

	public int makeChange(int n, int denom){
		if (n == 0){
			System.out.println();
			return 0;
		}
		
		int nextDenom = 0;
		switch (denom){
		case 25:
			nextDenom = 10;
			break;
			
		case 10:
			nextDenom = 5;
			break;
			
		case 5:
			nextDenom = 1;
			break;
			
		case 1:
			System.out.print(", "+n+"(cents) \n");
			return 1;
		}
		
		int ways = 0;
		for (int i = 0; i * denom <= n; i++){
			System.out.print(", "+i+"("+denom+"cents)");
			ways += makeChange(n - i*denom, nextDenom);
		}
		
		return ways;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeChange mc = new MakeChange();
	    System.out.println(mc.makeChange(100, 25));

	}

}
