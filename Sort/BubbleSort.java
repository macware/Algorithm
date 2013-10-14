package Sort;

public class BubbleSort {

	public void bubbleSort(int[] a) {
		if (a == null || a.length < 2)
			return;

		int i, j, tmp;
		for (i = 0; i < a.length; i++) {
			for (j = 1; j < a.length - i; j++) {
				if (a[j - 1] > a[j]) {
					tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
		}

		for (int t : a)
			System.out.print(t + " ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort bsort = new BubbleSort();
		bsort.bubbleSort(new int[] { 2, 3, 1, 4, 7, 8, 9 });
	}

}
