package CareerCup;

import java.util.*;

public class LongestWord {

	public Comparator<String> lenComp = new Comparator<String>(){

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			if (o1.length() < o2.length())
				return 1;
			else if (o1.length() > o2.length())
				return -1;
			
			return 0;
		}
		
	};
	
	public void test(){
		String[] strs = {"dog","walk","length","dogwalker"};
		Arrays.sort(strs,lenComp);
		
		System.out.println(strs[0].length());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestWord lw = new LongestWord();
		lw.test();

	}

}
