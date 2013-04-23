package DataStructures;

import java.util.*;

public class HTWTL {

	public static class htwt implements Comparable<Object> {
		public int h;
		public int w;

		public htwt(int height, int weight) {
			h = height;
			w = weight;
		}

		public int compareTo(Object o) {
			htwt second = (htwt) o;
			if (this.h != second.h) {
				return ((Integer) this.h).compareTo((Integer) second.h);
			} else {
				return ((Integer) this.w).compareTo((Integer) second.w);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		htwt[] hws = new htwt[5];
		hws[0] = new htwt(12, 13);
		hws[1] = new htwt(9, 12);
		hws[2] = new htwt(15, 11);
		hws[3] = new htwt(10, 14);
		hws[4] = new htwt(10, 13);

		Arrays.sort(hws);
		for (int i = 0; i < hws.length; i++)
			System.out.println(hws[i].h + " " + hws[i].w);
		
		ArrayList<Integer> arrs = new ArrayList<Integer>();
	}

}
