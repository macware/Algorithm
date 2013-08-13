package Search;

import java.util.*;

public class TextJustification {

	public ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		int i, start = 0, len = 0;
		for (i = 0; i < words.length; i++) {
			if (len + words[i].length() + i - start > L) {
				res.add(connect(words, start, i - 1, len, L, false));
				start = i;
				len = 0;
			}
			len += words[i].length();
		}

		res.add(connect(words, start, i - 1, len, L, true));
		return res;
	}

	public String connect(String[] words, int start, int end, int len, int L,
			boolean last) {
		StringBuilder sb = new StringBuilder();
		int i, n = end - start + 1;
		for (i = 0; i < n; i++) {
			sb.append(words[start + i]);
			addSpace(sb, i, n - 1, L - len, last);
		}

		if (n == 1 || last) {
			int spaces = L - len - (n - 1);
			while (spaces > 0) {
				sb.append(' ');
				spaces--;
			}
		}
		return sb.toString();
	}

	public void addSpace(StringBuilder sb, int i, int n, int L, boolean last) {
		if (i >= n)
			return;
		int spaces = last ? 1 : (L / n + (i < L % n ? 1 : 0));
		while (spaces > 0) {
			sb.append(' ');
			spaces--;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification tj = new TextJustification();
		System.out.println(tj.fullJustify(new String[] { "This", "is",
				"justification." }, 16));
	}
}
