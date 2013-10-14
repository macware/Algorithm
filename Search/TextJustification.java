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

	public void justifying(String[] words, int start, int n, int len, int L,
			ArrayList<String> res, boolean last) {
		StringBuilder sb = new StringBuilder();

		int spaces = L - len;
		int base;
		if (n == 0) {
			base = spaces;
			sb.append(words[start]);
			while (base-- > 0)
				sb.append(' ');
			res.add(sb.toString());
			return;
		}

		base = spaces / n;
		int count;

		for (int i = 0; i < n; i++) {
			sb.append(words[start + i]);
			count = (last ? 1 : base + (i < spaces % n ? 1 : 0));

			while (count-- > 0)
				sb.append(' ');
		}

		sb.append(words[start + n]);

		if (last) {
			count = L - n - len;
			while (count-- > 0)
				sb.append(' ');
		}

		res.add(sb.toString());
		return;
	}

	public ArrayList<String> fullJustify2(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		if (words == null || words.length == 0 || L < 0)
			return res;

		int start = 0, len = 0, n = 0;
		for (int i = 0; i < words.length; i++) {
			if (len + n + words[i].length() > L) {
				justifying(words, start, n - 1, len, L, res, false);
				start = i;
				len = 0;
				n = 0;
			}

			len += words[i].length();
			n++;
		}

		justifying(words, start, n - 1, len, L, res, true);

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification tj = new TextJustification();
		System.out.println(tj.fullJustify2(new String[] { "" }, 0));
	}
}
