package Sort;

public class MergeSort {

	private void mergeSort(int[] arr, int start, int end, int[] tmp) {

		if (start >= end)
			return;

		int mid = (start + end) / 2;
		mergeSort(arr, start, mid, tmp);
		mergeSort(arr, mid + 1, end, tmp);

		// Merging
		int i, j, k;
		i = start;
		j = mid + 1;
		k = start;

		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}

		while (i <= mid)
			tmp[k++] = arr[i++];
		while (j <= end)
			tmp[k++] = arr[j++];

		// Copy back
		for (k = start; k <= end; k++)
			arr[k] = tmp[k];
	}

	public void sort(int[] A) {
		int[] tmp = new int[A.length];
		mergeSort(A, 0, A.length - 1, tmp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort msort = new MergeSort();
		int[] A = new int[]{1,2,3,4,3,6,9,2,4,5,3};
		msort.sort(A);
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i]+" ");
	}

}
