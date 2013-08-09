package Search;

public class SearchRange {

	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[] { -1, -1 };

		if (A == null)
			return res;

		int lower = 0;
		int upper = A.length - 1;
		int mid = 0;

		while (lower <= upper) {
			mid = (lower + upper) / 2;
			if (A[mid] < target)
				lower = mid + 1;
			else if (A[mid] == target){
				upper = mid - 1;
			} else
				upper = mid;
		}

		if (A[lower] != target)
			return res;

		res[0] = lower;
		upper = A.length - 1;

		while (lower <= upper) {
			mid = (lower + upper) / 2;
			if (A[mid] > target)
				upper = mid - 1;
			else if (A[mid] == target){
				lower = mid + 1;
			} else
				lower = mid;
		}

		res[1] = upper;

		return res;

	}

	public int[] searchRange2(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] range = new int[]{-1,-1};
        int lower = 0;
        int upper = A.length - 1;
        int mid;

        // Search for lower bound
        while (lower < upper) {
            mid = (lower + upper) / 2;
            if (A[mid] < target)
                lower = mid + 1;
            else
                upper = mid;
        }

        // If the target is not found, return (-1, -1)
        if (A[lower] != target)
            return range;
        range[0] = lower;

        // Search for upper bound
        upper = A.length - 1;
        while (lower < upper) {
            mid = (int)(1.0 * (lower + upper) / 2 + 0.5);
            if (A[mid] > target)
                upper = mid - 1;
            else
                lower = mid;
        }
        range[1] = upper;

        return range;
    }
	
	public int[] searchRange3(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] range = new int[]{-1,-1};
        int lower = 0;
        int upper = A.length - 1;
        int mid;

        // Search for lower bound
        while (lower < upper) {
            mid = (lower + upper) / 2 - 1;
            if (mid < lower)
            	mid = lower;
            
            if (A[mid] < target)
                lower = mid + 1;
            else
                upper = mid;
        }

        // If the target is not found, return (-1, -1)
        if (A[lower] != target)
            return range;
        range[0] = lower;

        // Search for upper bound
        upper = A.length - 1;
        while (lower < upper) {
            mid = (lower + upper) / 2 + 1;       
            if (mid > upper)
            	mid = upper;
            
            if (A[mid] > target)
                upper = mid - 1;
            else
                lower = mid;
        }
        range[1] = upper;

        return range;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchRange srange = new SearchRange();
		int[] res = srange.searchRange3(new int[]{1,2,3},2);	
		System.out.println("["+res[0]+","+res[1]+"]");
	}

}
