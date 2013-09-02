package Search;

import java.util.*;

public class Triangle {

	int min;

	public void searching(ArrayList<ArrayList<Integer>> t, int level, int s,
			int val) {
		if (level == t.size()) {
			min = Math.min(min, val);
			return;
		}

		ArrayList<Integer> l = t.get(level);
		searching(t, level + 1, s, val + l.get(s));

		s++;
		if (s < l.size())
			searching(t, level + 1, s, val + l.get(s));
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (triangle == null || triangle.size() == 0)
			return 0;

		min = Integer.MAX_VALUE;
		searching(triangle, 0, 0, 0);

		return min;
	}

	/*
	 * A kind of dp, time cost is O(n^2)
	 */
	public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (triangle == null || triangle.size() == 0)
			return 0;

		ArrayList<Integer> pre = triangle.get(0);
		int tmp, min = pre.get(0);
		int i, j;

		for (i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			ArrayList<Integer> l = triangle.get(i);

			min = Integer.MAX_VALUE;
			for (j = 0; j < l.size() - 1; j++) {
				tmp = l.get(j) + pre.get(j);
				if (j > 0 && pre.get(j - 1) < pre.get(j))
					tmp = l.get(j) + pre.get(j - 1);
				min = Math.min(min, tmp);
				cur.add(tmp);
			}

			tmp = l.get(j) + pre.get(j - 1);
			min = Math.min(min, tmp);
			cur.add(tmp);

			pre = cur;
		}

		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
