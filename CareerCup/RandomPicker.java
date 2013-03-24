package CareerCup;

/* Chapter 18.3
 * Swap technique to main sort of code consistency. Like dealing with pivot in qsort
 */
public class RandomPicker {

	public int rand(int lower, int higher){
		return lower + (int)(Math.random() * (higher - lower + 1));
	}
	
	public int[] picking(int[] arr, int m){
		if (m > arr.length){
			System.out.println("Insufficient data size");
			return null;
		}
		
		int[] subset = new int[m];
		/* Don't corrupt the input if necessary */
		int[] origin = arr.clone();
		
		int idx;
		for (int j = 0; j < m; j++){
			idx = rand(j,origin.length-1);
			subset[j] = origin[idx];
			origin[idx] = origin[j];
		}
		
		return subset;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
