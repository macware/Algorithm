package CareerCup;

public class KMP {

	private int[] backtracking;

	public int kmpMatcher(String src, String target){
		buildBTtable(target);
		int m = 0, i = 0;
		
		while ((m+i) < src.length()){
			if (target.charAt(i) == src.charAt(m+i)){
				if (i == target.length() - 1)
					return m;
				i++;
			} else {
				m = m + i - backtracking[i];
				if (backtracking[i] > -1)
					i = backtracking[i];
				else
					i = 0;
			}
		}
		
		return -1;
	}
	
	public void buildBTtable(String target) {
		backtracking = new int[target.length()];
		int pos, cnt;

		backtracking[0] = -1;
		backtracking[1] = 0;
		pos = 2;
		cnt = 0;

		while (pos < backtracking.length) {
			if (target.charAt(pos - 1) == target.charAt(cnt)) {
				// continue the substring
				cnt++;
				backtracking[pos] = cnt;
				pos++;
			} else if (cnt > 0) {
				// backtracking itself
				cnt = backtracking[cnt];
			} else {
				// cnt == 0
				backtracking[pos] = 0;
				pos++;
			}
		}

		for (int i = 0; i < backtracking.length; i++) {
			System.out.print(backtracking[i] + " ");
		}
	}

	public void kmpMatcher2(String src,String target){
		buildBt(target);
		
		int i,j;
		j = -1;
		for (i = 0; i < src.length(); i++){
			while (j > -1 && target.charAt(j+1) != src.charAt(i)){
				j = backtracking[j] - 1;
			}
			if (target.charAt(j+1) == src.charAt(i))
				j++;
			if (j == target.length()-1){
				System.out.println("Pattern occurs at "+(i-target.length()+1));
				j = -1;
			}
		}
		
		System.out.println("Finished");
	}
	
	public void buildBt(String target){
		backtracking = new int[target.length()];
	
		 /* Record if failed at j+1, I can make sure the fist backtracking[j] words
		  * would match the last backtracking[j] words in target[0..j];
		  */
		backtracking[0] = 0;
		
		int i,j;
		j = -1;
		for (i = 1; i < target.length(); i++){
			while ( j > -1 && target.charAt(j+1) != target.charAt(i)){
				j = backtracking[j] - 1;
			}
			if (target.charAt(j+1) == target.charAt(i))
				j++;
			
			backtracking[i] = j + 1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMP kmp = new KMP();
//		int w = kmp.kmpMatcher("ABC ABCDAB ABCDABCDABDE", "ABCDABD");
//		System.out.println("\n the result is "+w);
		kmp.kmpMatcher2("ABC ABCDAB ABCDABCDABDE", "ABCDABD");
		//kmp.kmpMatcher2("ABABABAAABAB", "ABAB");
	}

}
