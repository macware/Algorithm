package Search;

public class TrapWater {

	public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0, h = 0, water = 0;
        int i;
        for (i = 0; i < A.length; i++)
            if (A[i] > A[max])
                max = i;
                
        for (i = 0; i < max; i++)
            if (h > A[i])
                water += h - A[i];
            else
                h = A[i];
                
        h = 0;
        for (i = A.length - 1; i > max; i--)
            if (h > A[i])
                water += h - A[i];
            else
                h = A[i];
                
        return water;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
