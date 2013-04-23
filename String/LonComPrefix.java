package String;

public class LonComPrefix {

	/*
	 * Longest Common Prefix. Some times it's not that easy to come up with a
	 * brute force way. The key idea is: think the problem in a natural way, as
	 * straight forward as possible.
	 */
	public String longestCommonPrefix_Bad(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (strs == null || strs.length == 0 || strs[0].equals(""))
			return "";
		if (strs.length == 1)
			return strs[0];

		int i, j;

		for (j = 0; j < strs[0].length(); j++) {
			for (i = 1; i < strs.length; i++) {
				if (strs[i].length() <= j
						|| strs[i].charAt(j) != strs[0].charAt(j)) {
					System.out.println("j = " + j);
					return strs[0].substring(0, j);
				}
			}
		}

		System.out.println("j = " + j);
		return strs[0].substring(0, j);
	}

	/*
	 * Thought: Find the common by refining the result on each check(iteration), since
	 * this common is shared by the group, each member should be larger or equal
	 * to it. Check one after another VS all at the same time.
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		String prefix = strs[0];
		int i, j;

		for (i = 1; i < strs.length; i++) {
			String s = strs[i];
			for (j = 0; j < Math.min(prefix.length(), s.length()); j++)
				if (s.charAt(j) != prefix.charAt(j))
					break;
			prefix = prefix.substring(0, j);
		}

		return prefix;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
