package DP;

import java.util.*;

public class ZeroOneBag {

	private int size, num;
	private int[] ans;
	private int[] weight;
	private int[] value;

	public ZeroOneBag(int size, int n) {
		this.size = size;
		num = n;
		ans = new int[size + 1];
		weight = new int[n];
		value = new int[n];
	}

	private void bagging(int w, int v) {
		for (int i = size; i >= w; i--) {
			if (ans[i - w] + v > ans[i])
				ans[i] = ans[i - w] + v;
		}
	}

	public void solve() {
		// init ans;
		int i = 0;
		for (i = 0; i <= size; i++)
			ans[i] = 0;

		// get weight value pair
		Scanner scan = new Scanner(System.in);
		for (i = 0; i < num; i++) {
			weight[i] = scan.nextInt();
			value[i] = scan.nextInt();
		}
		scan.close();

		for (i = 0; i < num; i++)
			bagging(weight[i], value[i]);

		System.out.println("Max " + ans[size]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input total weight and number");
		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		int n = scan.nextInt();

		System.out.println("ZeroOneBag Starts");
		scan.nextLine();

		ZeroOneBag zo = new ZeroOneBag(w, n);
		zo.solve();
	}

}
