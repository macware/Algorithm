package Search;

public class SearchInsertPos {

	int search(int[] A, int start, int end, int target) {
		if (start > end) {
			if (start == 0)
				return 0;

			return end;
		}

		int mid = (start + end) / 2;
		if (A[mid] == target)
			return mid;

		if (A[mid] > target)
			return search(A, start, mid - 1, target);
		else {
			if (mid + 1 >= A.length)
				return A.length;

			if (A[mid + 1] >= target)
				return mid + 1;
			else
				return search(A, mid + 1, end, target);
		}
	}

	public int searchHelper(int[] A, int start, int end, int target) {
		if (start > end)
			return start;

		int mid = (start + end) / 2;
		if (A[mid] == target)
			return mid;

		if (A[mid] < target) {
			if (mid == A.length - 1 || target < A[mid + 1])
				return (mid + 1);
			else
				return searchHelper(A, mid + 1, end, target);
		} else {
			if (mid == 0 || target > A[mid - 1])
				return mid;
			else
				return searchHelper(A, start, mid - 1, target);
		}
	}

	public int searchInsert_best(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0)
            return -1;
            
        int mid, l = 0, r = A.length - 1;
        while (l <= r){
            mid = (l + r)/2;
            if (A[mid] == target)
                return mid;
            
            if (mid > 0 && A[mid] > target && A[mid-1] < target)
                return mid;
            
            if (A[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return l;
    }
	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0)
			return 0;

		return search(A, 0, A.length - 1, target);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPos sip = new SearchInsertPos();
		System.out.println(sip.searchInsert(new int[]{1,2,2,3}, 2));
	}

}
