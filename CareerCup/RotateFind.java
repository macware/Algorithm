package CareerCup;

public class RotateFind {

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
