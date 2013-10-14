package Search;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0
				|| gas.length != cost.length)
			return -1;

		int startIdx = -1;
		int total = 0, sum = -1, delta;
		for (int i = 0; i < gas.length; i++) {
			delta = gas[i] - cost[i];
			if (sum < 0) {
				/*
				 * If you can't reach me, I will treat myself as the start
				 * index. Is it possible for the start index to sit between us?
				 * No! If that is the case, we must have changed to it already.
				 * We can also prove it by contradiction.
				 * 
				 * Why we can ganrantee that the start index can go back from 0
				 * to itself? Because the total is >= 0!
				 */
				startIdx = i;
				sum = delta;
			} else
				sum += delta;
			
			total += delta;
		}

		return (total >= 0 ? startIdx : -1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation gs = new GasStation();
		System.out.println(gs.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 },
				new int[] { 3, -1, 5, 5, 2 }));

	}

}
