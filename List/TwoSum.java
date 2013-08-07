package List;

import java.util.*;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[2];
		if (numbers == null || numbers.length == 0)
			return res;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int rem = target - numbers[i];
			if (map.containsKey(rem)) {
				res[1] = i + 1;
				res[0] = map.get(rem);
				break;
			}
			map.put(numbers[i], i + 1);
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] { 1, 3, 2, 5, 4 };
		Arrays.sort(num);
		System.out.println(num[4]);
	}

}
