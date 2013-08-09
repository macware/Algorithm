package String;

import java.util.*;

public class FindAllStrConcat {

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (S.length() == 0 || L.length == 0)
			return res;

		int i;
		HashMap<String, Integer> records = new HashMap<String, Integer>();
		for (i = 0; i < L.length; i++) {
			if (records.containsKey(L[i]))
				records.put(L[i], records.get(L[i]) + 1);
			else
				records.put(L[i], 1);
		}

		i = 0;
		int len = L[0].length();
		int total_len = L.length * len;
		int n = S.length();

		while (n - i >= total_len) {
			HashMap<String, Integer> tmp = new HashMap<>(records);
			for (int j = 0; j < L.length; j++) {
				String test = S.substring(i + j * len, i + (j + 1) * len);
				if (tmp.containsKey(test)) {
					int count = tmp.get(test) - 1;
					if (count == 0)
						tmp.remove(test);
					else
						tmp.put(test, count);
				} else
					break;
			}

			if (tmp.size() == 0)
				res.add(i);
			i++;
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllStrConcat fasc = new FindAllStrConcat();
		System.out.println(fasc.findSubstring("baabc",
				new String[] { "a", "b", "c" }));
	}

}
