package Search;

public class FirstMissingPositive {

	/*
	 * Make an array as a hash table
	 */
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0)
			return 1;

		int outOfRange = A.length + 2;
		int i;

		// first run, turn every negetive value into an impossible positive
		// value. make every value in A is positive
		for (i = 0; i < A.length; i++)
			if (A[i] <= 0)
				A[i] = outOfRange;

		// second run, make A[] as a hash table, A[i] indicate the presence of i
		// + 1. the way is that, if k in [1,n] is in A[], then turn A[k -1] to
		// negetive.
		for (i = 0; i < A.length; i++) {
			int absi = Math.abs(A[i]);
			if (absi <= A.length) {
				A[absi - 1] = -1 * Math.abs(A[absi - 1]);
			}
		}

		// third run, if A[i] is positive, from step 2, we know that i + 1 is
		// missing.
		for (i = 0; i < A.length; i++)
			if (A[i] > 0)
				return (i + 1);

		// all int from 1 to n is present, then return n + 1
		return (A.length + 1);
	}
	
	public int firstMissingPositive2(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        
        // preprocess all negative elements
        for (i = 0; i < A.length; i++){
            if (A[i] <= 0)
                A[i] = A.length + 1;
        }
        
        // reverse
        int tmp;
        for (i = 0; i < A.length; i++){
            tmp = Math.abs(A[i]);
            if (tmp > A.length)
                continue;
            A[tmp-1] = -Math.abs(A[tmp-1]);
        }
        
        // check
        for (i = 0; i < A.length; i++){
            if (A[i] > 0)
                break;
        }
        
        return (i+1);
    }
	
	public int firstMissingPositive3(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        
        // swap
        int tmp;
        for (i = 0; i < A.length; i++){
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)){
                tmp = A[A[i]-1];
                if (A[i] == tmp)
                    break;
                    
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        
        // check
        for (i = 0; i < A.length; i++){
            if (A[i] != (i+1))
                break;
        }
        
        return (i+1);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
