package DP;
import java.util.*;

// Chapter 9.6
public class DFS_pairing_parenthesis {

	public static int count = 0;

	public static void print(ArrayList<String> result) {
		count++;
		for (String s : result)
			System.out.print(s);
		System.out.println();
	}

	public static void parenthesis(int lc, int rc, ArrayList<String> result) {
		if (lc == 0 && rc == 0)
			print(result);

		if (lc > 0) {
			result.add("(");
			parenthesis(lc - 1, rc, result);
			result.remove(result.size() - 1);
		}

		if (lc < rc) {
			result.add(")");
			parenthesis(lc, rc - 1, result);
			result.remove(result.size() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		parenthesis(4,4,result);
		System.out.println("Total "+count);

	}

}
