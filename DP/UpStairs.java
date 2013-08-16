package DP;

import java.util.*;

// Chapter 9.1
public class UpStairs {

	public static void print(ArrayList<Integer> result) {
		for (Integer i : result)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void up(int steps, ArrayList<Integer> result) {
		switch (steps) {
		case 0:
			print(result);
			break;

		case 1:
			result.add(1);
			up(0, result);
			result.remove(result.size() - 1);
			break;

		case 2:
			result.add(1);
			up(1, result);
			result.remove(result.size() - 1);

			result.add(2);
			up(steps - 2, result);
			result.remove(result.size() - 1);
			break;

		default:
			result.add(1);
			up(steps - 1, result);
			result.remove(result.size() - 1);

			result.add(2);
			up(steps - 2, result);
			result.remove(result.size() - 1);

			result.add(3);
			up(steps - 3, result);
			result.remove(result.size() - 1);
		}
	}

	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int f0 = 1;
		int f1 = 1;

		for (int i = 1; i < n; i++) {
			int f2 = f1 + f0;
			f0 = f1;
			f1 = f2;
		}

		return f1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = new ArrayList<Integer>();

		up(4, result);
	}

}
