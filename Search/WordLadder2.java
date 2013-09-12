package Search;

import java.util.*;

public class WordLadder2 {

	public class WordNode {
		public String word;
		public int depth;
		public ArrayList<WordNode> parents;

		public WordNode(String s, int d) {
			word = s;
			depth = d;
			parents = new ArrayList<WordNode>(5);
		}
	}

	public void constructing(WordNode node, ArrayList<ArrayList<String>> res,
			ArrayList<String> item) {
		if (node == null) {
			ArrayList<String> sol = new ArrayList<String>();
			for (int i = item.size() - 1; i >= 0; i--)
				sol.add(item.get(i));
			res.add(sol);
			return;
		}

		item.add(node.word);
		for (WordNode p : node.parents)
			constructing(p, res, item);
		item.remove(item.size() - 1);
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (start == null || end == null)
			return res;

		if (start.equals(end)) {
			ArrayList<String> item = new ArrayList<String>();
			item.add(start);
			res.add(item);
			return res;
		}

		Queue<WordNode> que = new LinkedList<WordNode>();
		HashMap<String, WordNode> map = new HashMap<String, WordNode>();
		WordNode root = new WordNode(start, 1);
		root.parents.add(null);

		map.put(start, root);
		que.add(root);

		int i, minLen = 0;
		ArrayList<WordNode> sol = new ArrayList<WordNode>();
		char c;

		while (true) {
			WordNode w = que.remove();
			if (w.depth == minLen)
				break;

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
						node.parents.add(w);
						if (tmp.equals(end)) {
							minLen = node.depth;
							sol.add(node);
						}
						map.put(tmp, node);
						que.add(node);
					} else if (node.depth == w.depth + 1)
						node.parents.add(w);
				}
			}
		}

		ArrayList<String> item = new ArrayList<String>();
		for (WordNode strap : sol) {
			constructing(strap, res, item);
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
