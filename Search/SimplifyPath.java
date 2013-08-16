package Search;

import java.util.*;

public class SimplifyPath {

	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> entries = new ArrayList<String>();
		int k = -1;

		String[] items = path.trim().split("/");
		for (int i = 0; i < items.length; i++) {
			if (items[i].length() == 0 || items[i].equals("."))
				continue;

			if (items[i].equals("..")) {
				k--;
				if (k < -1)
					k = -1;
			} else {
				k++;
				if (k < entries.size())
					entries.set(k, items[i]);
				else
					entries.add(items[i]);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("/");
		for (int i = 0; i <= k; i++) {
			sb.append(entries.get(i));
			if (i != k)
				sb.append("/");
		}

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/.hidden"));
	}

}
