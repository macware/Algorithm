package Search;

public class LookAndSay {

	public String lookAndSay(String seed, int numIterations) {
		if (numIterations < 0)
			return seed;

		StringBuilder res = new StringBuilder(seed);
		StringBuilder next;

		for (int i = 1; i <= numIterations; i++) {
			next = new StringBuilder();
			char tag = res.charAt(0);
			int count = 1;
			for (int j = 1; j < res.length(); j++) {
				if (res.charAt(j) != tag) {
					next.append(count);
					next.append(tag);

					tag = res.charAt(j);
					count = 0;
				}
				count++;
			}
			next.append(count);
			next.append(tag);
			res = next;
		}

		return res.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LookAndSay las = new LookAndSay();
		for(int i = 0; i < 5; i++)
			System.out.println(las.lookAndSay("1", i));
	}

}
