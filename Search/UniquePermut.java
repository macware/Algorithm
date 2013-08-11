package Search;

import java.util.*;

/**
 * Use the same number in the same level once (the first one), when the second
 * one can be used in lower levels but won't be used in the same level again.
 * 
 * @author czx
 * 
 */
public class UniquePermut {

	public void dfs(int[] num, boolean[] used, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> res) {
		if (item.size() == num.length) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = 0; i < used.length; i++) {
			if (i > 0 && num[i] == num[i - 1] && !used[i - 1])
				continue;

			if (!used[i]) {
				used[i] = true;
				item.add(num[i]);
				dfs(num, used, item, res);
				used[i] = false;
				item.remove(item.size() - 1);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return res;

		ArrayList<Integer> item = new ArrayList<Integer>();
		Arrays.sort(num);
		boolean[] used = new boolean[num.length];

		dfs(num, used, item, res);

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
