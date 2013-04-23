package Math;

import java.util.*;
public class PrevPermut {

	public Comparator<Integer> incComp = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);	
		}
	};
	
	public class Pair {
		public int i;
		public int j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private void getCloserIncPair(Integer[] num, Pair pair) {

		int start = 0;
		int end = num.length - 1;

		int i;
		while (start < end) {
			for (i = end - 1; i >= start; i--)
				if (num[i] > num[end]) {
					pair.i = i;
					pair.j = end;
					break;
				}
			
			start = i+1;
			end = end-1;
		}
	}

	public void prevPermutation(Integer[] num) {
		if (num == null || num.length < 2)
			return;
		Pair pair = new Pair(-1, -1);
		getCloserIncPair(num, pair);
		if (pair.i != -1){
			int tmp = num[pair.i];
			num[pair.i] = num[pair.j];
			num[pair.j] = tmp;
		}
		Arrays.sort(num, pair.i+1, num.length, incComp);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] num = new Integer[] { 4,2,2,2,1,3 };
		PrevPermut pp = new PrevPermut();
		pp.prevPermutation(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}

}
