package DataStructures;

import java.util.ArrayList;
import java.util.Collections;

public class Compare {

	public class Part implements Comparable<Part> {
		public int start;
		public int end;

		public Part(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Part p) {
			// TODO Auto-generated method stub
			if (start < p.start)
				return -1;
			else if (start > p.start)
				return 1;

			return 0;
		}
	}

	public void testPart() {
		ArrayList<Part> partList = new ArrayList<Part>();
		partList.add(new Part(8, 10));
		partList.add(new Part(1, 3));
		partList.add(new Part(15, 18));
		partList.add(new Part(2, 6));

		Collections.sort(partList);

		for (Part p : partList)
			System.out.println("[" + p.start + "," + p.end + "]");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
