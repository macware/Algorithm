package Search;

import java.util.*;

public class LetterComb {

	public void dfs(String digits, ArrayList<String> res, StringBuffer cur) {
		if (digits.length() == 0) {
			res.add(cur.toString());
			return;
		}

		char off = (char) (digits.charAt(0) - '2');
		char start = (char) (off * 3 + 'a');

		if (off > 5)
			start++;
		int num = 3;
		if (off == 5 || off == 7)
			num = 4;

		for (int i = 0; i < num; i++, start++) {
			cur.append(start);
			dfs(digits.substring(1), res, cur);
			cur.deleteCharAt(cur.length()-1);
		}

	}

	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		StringBuffer cur = new StringBuffer();

		dfs(digits, res, cur);
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterComb lc = new LetterComb();
		System.out.println(lc.letterCombinations("28"));
	}

}
