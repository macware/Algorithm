package Sort;

public class MergeTwoSortedArray {

	public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i,j,k;
        
        k = m + n - 1;
        i = m - 1;
        j = n - 1;
        
        while (i >= 0 && j >= 0){
            if (A[i] >= B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        
        while (j >= 0)
            A[k--] = B[j--];           
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
