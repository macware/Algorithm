package Search;

import java.util.*;

public class wordLadder1 {

	public class WordNode {
		public String word;
		public int depth;

		public WordNode(String s, int d) {
			word = s;
			depth = d;
		}
	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if ((start == null && end == null) || start.equals(end))
			return 1;

		if (start == null || end == null)
			return 0;

		Queue<WordNode> que = new LinkedList<WordNode>();
		HashMap<String, WordNode> map = new HashMap<String, WordNode>();
		WordNode root = new WordNode(start, 1);
		map.put(start, root);

		que.add(root);

		int i;
		char c;

		while (!que.isEmpty()) {
			WordNode w = que.remove();
			String s = w.word;

			for (i = 0; i < s.length(); i++) {
				StringBuilder sb = new StringBuilder(s);
				for (c = 'a'; c <= 'z'; c++) {
					if (s.charAt(i) == c)
						continue;

					sb.setCharAt(i, c);
					String tmp = sb.toString();
					if (!dict.contains(tmp))
						continue;

					WordNode node = map.get(tmp);
					if (node == null) {
						node = new WordNode(tmp, w.depth + 1);
						if (tmp.equals(end))
							return node.depth;
						map.put(tmp, node);
						que.add(node);
					}
				}
			}
		}

		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
