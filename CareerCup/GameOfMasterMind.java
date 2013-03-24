package CareerCup;

// Chapter 17.5
public class GameOfMasterMind {

	public class Result {
		public int hits;
		public int pseudoHits;

		public String toString() {
			return "(" + hits + "," + pseudoHits + ")";
		}
	}

	private int coder(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}
	
	public Result estimate(String guess,String solution){
		if (guess.length() != solution.length())
			return null;
		Result res = new Result();
		int[] freq = new int[4];
		
		int i;
		for (i = 0; i < solution.length(); i++){
			if (guess.charAt(i) == solution.charAt(i)){
				res.hits++;
			} else {
				freq[coder(solution.charAt(i))]++;
			}
		}
		
		for (i = 0; i < guess.length(); i++){
			int code = coder(guess.charAt(i));
			if (code >= 0 && freq[code] > 0 && guess.charAt(i) != solution.charAt(i)){
				res.pseudoHits++;
				freq[code]--;
			}
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameOfMasterMind gmm = new GameOfMasterMind();
		System.out.println(gmm.estimate("BRRB", "GRBR").toString());
	}

}
