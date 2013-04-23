package Search;

public class RotateFind {

	public int searchHelper(int[] A, int start, int end, int target){
        if (start > end)
            return -1;
        
        int mid = (start + end)/2;
        if (A[mid] == target)
            return mid;
            
        if (A[start] < A[mid]){
            if (target >= A[start] && target < A[mid])
                return searchHelper(A, start, mid-1, target);
            else
                return searchHelper(A, mid+1, end, target);
        } else if (A[mid] < A[start]){
            if (target > A[mid] && target <= A[end])
                return searchHelper(A, mid+1, end, target);
            else
                return searchHelper(A, start, mid -1, target);
        } else {
            return searchHelper(A, mid+1, end, target);
        }
        
    }

	// Assume no duplicates
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0)
            return -1;
            
        return searchHelper(A, 0, A.length - 1, target);
    }
    
	public int find(int[] arr, int start, int end, int x){
		if (end < start)
			return -1;
		
		int mid = (start + end)/2;
		if (arr[mid] == x)
			return mid;
		
		if (arr[start] < arr[mid]){
			if ( x >= arr[start] && x < arr[mid]){
				return find(arr, start, mid-1,x);
			} else 
				return find(arr, mid+1, end,x);
		} else if (arr[mid] < arr[start]){
			if ( x> arr[mid] && x <= arr[end])
				return find(arr,mid+1,end,x);
			else
				return find(arr,start,mid-1,x);
		} else{
			if (arr[mid] != arr[end]){
				return find(arr,mid+1,end, x);
			} else {
				int result = find(arr,start,mid-1,x);
				if (result == -1){
					result = find(arr,mid+1,end,x);
				}
				return result;
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
