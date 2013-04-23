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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SearchRange srange = new SearchRange();
//		int[] res = srange.searchRange(new int[]{1},0); 	
//		System.out.println("["+res[0]+","+res[1]+"]");
		
		String test = "test";
		System.out.println(test.substring(0, 4));
	}

}
