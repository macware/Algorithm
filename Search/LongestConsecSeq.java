package Search;

import java.util.*;

public class LongestConsecSeq {

	public int expand(HashSet<Integer> set, int start, int dir) {
		int count = 0;
		int next = start + dir;
		while (set.contains(next)) {
			count++;
			set.remove(next);
			next += dir;
		}

		return count;
	}

	public int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null)
			return 0;

		int newMax = 0, max = 0;
		int i;

		HashSet<Integer> set = new HashSet<Integer>();
		for (i = 0; i < num.length; i++)
			set.add(num[i]);

		for (i = 0; i < num.length; i++) {
			newMax = 1;
			if (set.contains(num[i])) {
				set.remove(num[i]);
				newMax = newMax + expand(set, num[i], -1)
						+ expand(set, num[i], 1);
			}
			max = Math.max(max, newMax);
		}

		return max;
	}

	public int find(int start, int dif, HashSet<Integer> set) {
		int count = 0;

		start += dif;
		while (set.contains(start)) {
			count++;
			set.remove(start);
			start += dif;
		}

		return count;
	}

	public int longestConsecutive2(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length == 0)
			return 0;

		HashSet<Integer> set = new HashSet<Integer>();
		int i;
		for (i = 0; i < num.length; i++)
			set.add(num[i]);

		int len = 0;
		for (i = 0; i < num.length; i++) {
			if (set.contains(num[i]))
				len = Math.max(len,
						1 + find(num[i], -1, set) + find(num[i], 1, set));
			set.remove(num[i]);
		}

		return len;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecSeq lconse = new LongestConsecSeq();
		System.out.println(lconse.longestConsecutive(new int[] { 100, 4, 200,
				1, 3, 2 }));
	}

}
