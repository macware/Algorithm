package Search;

// Chapter 17.6
public class ExtractRange {

	int subLeft(int[] arr){
		int i;
		for(i = 1; i < arr.length; i++){
			if (arr[i] < arr[i-1]) break;
		}
		return (i-1);
	}
	
	int subRight(int[] arr){
		int i;
		for ( i = arr.length - 2; i >= 0; i--){
			if (arr[i] > arr[i+1]) return (i+1);
		}
		return 0;
	}
	
	int shrinkLeft(int[] arr,int min_idx, int start){
		int i;
		for (i = start; i >= 0; i--){
			if (arr[i] <= arr[min_idx]) return (i+1);
		}
		
		return 0;
	}
	
	int shrinkRight(int[] arr, int max_idx, int start){
		int i;
		for (i = start; i < arr.length; i++){
			if (arr[i] > arr[max_idx]) return (i-1);
		}
		
		return arr.length - 1;
	}
	
	void extract(int[] arr){
		int l = subLeft(arr);
		int r = subRight(arr);
		
		int min_idx = l + 1;
		if (min_idx >= arr.length) return;
		
		int max_idx = r - 1;
		for (int i = l + 1; i < r - 1; i++){
			if (arr[i] < arr[min_idx]) min_idx = i;
			if (arr[i] > arr[max_idx]) max_idx = i;
		}
		
		int left = shrinkLeft(arr,min_idx,l);
		int right = shrinkRight(arr,max_idx,r);
		
		System.out.println("From "+left+" to "+right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtractRange er = new ExtractRange();
		int[] arr = new int[]{1,2,4,7,10,7,12,6,7,16,18,19};
		er.extract(arr);

	}

}
