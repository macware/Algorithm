package Math;

public class Power {

	public int pow(int m, int n) {
		if (n == 1)
			return m;
		if (n == 0)
			return 1;

		if (n % 2 == 1) {
			return m * pow(m, n - 1);
		} else {
			return pow(m, n / 2) * pow(m, n / 2);
		}
	}

	public double powHelper(double x, int n){
        if (n == 0)
            return 1;
            
        if (n % 2 == 0)
            return powHelper(x,n/2)*powHelper(x,n/2);
        else
            return powHelper(x,n-1)*x;
    }
    
	public double powHelper2(double x, int n){
        if (n == 0)
            return 1;
            
        double half = powHelper(x, n/2);
        if (n % 2 == 0)
            return  half * half;
        else
            return x * half * half;
    }
	
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0)
            return 1;
            
        if (x == 0)
            return 0;
            
        if (n < 0)
            return 1/(powHelper(x,-n));
            
        return powHelper(x,n);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power power = new Power();
		System.out.println(3 << 2);
	}

}
