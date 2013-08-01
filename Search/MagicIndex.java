package Search;

public class MagicIndex {

	public static int magicDistinct(int[] ints, int start, int end) {
		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (ints[mid] == mid)
			return mid;
		if (ints[mid] < mid)
			return magicDistinct(ints, mid + 1, end);
		else
			return magicDistinct(ints, start, mid - 1);

	}

	public static int magicDup(int[] ints, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (ints[mid] == mid)
			return mid;

		int magic = -1;
		if (ints[mid] < mid) {
			magic = magicDup(ints, Math.max(ints[mid], mid + 1), end);
		}

		if (magic < 0) {
			magic = magicDup(ints, start, Math.min(mid - 1, ints[mid]));
		}

		return magic;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] ints = new int[]{-40,-20,-1,1,2,3,5,7,9,12,13};
		// int magic = magicDistinct(ints, 0, ints.length - 1);

		int[] ints = new int[] { -10, -5, 2, 2, 2, 3, 5, 7, 9, 12, 13 };
		int magic = magicDup(ints, 0, ints.length - 1);
		System.out.println("The magic number is: " + magic);
	}

}
