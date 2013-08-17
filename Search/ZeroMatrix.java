package Search;

public class ZeroMatrix {

	// O(cols)
	public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
            
        int i,j,k;
        int[] cols = new int[matrix[0].length];
        
        for (i = 0; i < matrix.length; i++){
            k = -1;
            
            for (j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    cols[j] = 1;
                    if (k == -1)
                        k = j;
                }
                
                if (k != -1)
                    matrix[i][j] = 0;
            }
            
            for (j = 0; j < k; j++)
                matrix[i][j] = 0;
        }
        
        for (j = 0; j < matrix[0].length; j++){
            if (cols[j] == 1){
                for (i = 0; i < matrix.length; i++)
                    matrix[i][j] = 0;
            }
        }
    }
	
	public void setZeroes_o1(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		int i, j, k, r = -1;
		// r - reference row to represent the reused space to indicate zero columns
		// k - indicates the first zero column of this row

		for (i = 0; i < matrix.length; i++) {
			k = -1;

			for (j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (r == -1)
						r = i;

					if (k == -1)
						k = j;

					if (r == i)
						matrix[i][j] = 1;
					else
						matrix[r][j] = 1;

				} else if (k != -1) {
					matrix[i][j] = 0;
				}
			}

			for (j = 0; j < k; j++)
				matrix[i][j] = 0;
		}

		if (r == -1)
			return;
		
		for (j = 0; j < matrix[0].length; j++) {
			// check negative (check valid index)
			if (matrix[r][j] == 1) {
				for (i = 0; i < matrix.length; i++)
					matrix[i][j] = 0;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
