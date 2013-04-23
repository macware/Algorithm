package Sort;

public class RemoveSortedDup {

	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null)
    		return 0;
		if (A.length < 2)
			return A.length;

		int cur, j;
		cur = 0;
        
        for (j = 1; j < A.length; j++){
            if (A[j] != A[j-1]){
                A[++cur] = A[j];
            }
        }

        
		return (cur + 1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
