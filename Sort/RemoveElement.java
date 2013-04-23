package Sort;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0)
            return 0;
            
        int k = -1;
        for (int i = 0; i < A.length; i++){
            if (A[i] != elem)
                A[++k] = A[i];
        }
        
        return (k+1);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
