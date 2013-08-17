package Search;

public class Search2DMatrix {

	public boolean searchHelper(int[][] matrix, int start, int end, int target){
        if (start > end)
            return false;
            
        int mid = (start + end)/2;
        int i = mid / matrix[0].length;
        int j = mid % matrix[0].length;
        
        if (matrix[i][j] == target)
            return true;
            
        if (matrix[i][j] < target)
            return searchHelper(matrix, mid + 1, end, target);
        else
            return searchHelper(matrix, start, mid - 1, target);
    }
	
	public boolean searchHelper2(int[][] matrix, int start, int end, int target){
        int i,j,mid;
        
        while (start <= end){
        	mid = (start + end)/2;
        	i = mid / matrix[0].length;
        	j = mid % matrix[0].length;
        	
        	if (matrix[i][j] == target)
        		return true;
        	
        	if (matrix[i][j] < target)
        		start = mid + 1;
        	else
        		end = mid - 1;
        }
        
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
            
        int end = matrix.length * matrix[0].length - 1;
        
        return searchHelper(matrix, 0, end, target);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
