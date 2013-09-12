package Search;

import java.util.*;

public class WordLadder {

	public class WordNode {
		public String str;
		public int count;
		public ArrayList<WordNode> parent;

		public WordNode(String s, int c) {
			str = s;
			count = c;
			parent = new ArrayList<WordNode>();
		}
	}

	@SuppressWarnings("unchecked")
	public void constructHelper(WordNode node, ArrayList<String> newRes, ArrayList<ArrayList<String>> res){
		if (node == null){
			res.add((ArrayList<String>)newRes.clone());
			return;
		}
		
		newRes.add(0, node.str);
		for (WordNode p: node.parent)
			constructHelper(p,newRes,res);
		newRes.remove(0);
	}
	
	
	public ArrayList<ArrayList<String>> construct(ArrayList<WordNode> wlist){
		ArrayList<String> newRes = new ArrayList<String>();
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		for (WordNode node: wlist)
			constructHelper(node, newRes, res);
		for (ArrayList<String> aRes: res)
			System.out.println(aRes);
		return res;
	}
	
	public void constructing(WordNode node, ArrayList<ArrayList<String>> res, ArrayList<String> item){
        if (node == null){
        }
    }
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (start.equals(end))
			return 2;

		Map<String, WordNode> visited = new HashMap<String, WordNode>();
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		ArrayList<WordNode> res = new ArrayList<WordNode>();

		WordNode cur = new WordNode(start, 1);
		cur.parent.add(null);
		visited.put(start, cur);
		queue.add(cur);
		int minLen = 0;

		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.count == minLen)
				break;

			for (int i = 0; i < start.length(); i++) {
				StringBuilder sb = new StringBuilder(cur.str);
				for (char c = 'a'; c <= 'z'; c++) {
					if (sb.charAt(i) == c)
						continue;

					sb.setCharAt(i, c);
					String tmp = sb.toString();
					if (!dict.contains(tmp))
						continue;

					WordNode node = visited.get(tmp);
					if (node == null) {
						node = new WordNode(tmp, cur.count + 1);
						if (tmp.equals(end)) {
							minLen = node.count;
							res.add(node);
						}
						visited.put(tmp, node);
						node.parent.add(cur);
						queue.offer(node);
					} else {
						if (cur.count + 1 == node.count)
							node.parent.add(cur);
					}
				}
			}
		}

		if (res.size() > 0)
			construct(res);
		return minLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder wl = new WordLadder();
		
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dit");
		dict.add("dog");
		dict.add("dot");
		dict.add("lot");
		dict.add("cog");
		
		System.out.println(wl.ladderLength("hit", "cog", dict));
	}

}
