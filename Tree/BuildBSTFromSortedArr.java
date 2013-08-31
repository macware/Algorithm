package Tree;

public class BuildBSTFromSortedArr {

	public TreeNode building(int[] num, int s, int e) {
		if (s > e)
			return null;

		int mid = (s + e) / 2;
		TreeNode root = new TreeNode(num[mid]);

		root.left = building(num, s, mid - 1);
		root.right = building(num, mid + 1, e);

		return root;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null)
			return null;

		return building(num, 0, num.length - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
