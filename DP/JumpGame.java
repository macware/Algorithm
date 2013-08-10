package DP;

import java.util.Arrays;

public class JumpGame {

	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length < 1)
			return true;

		int[] bt = new int[A.length];
		int[] dp = new int[A.length];

		Arrays.fill(bt, -1);
		Arrays.fill(dp, A.length + 1);

		bt[0] = 0;
		dp[0] = 0;
		int i, j;
		for (i = 1; i < A.length; i++) {
			if (A[i - 1] == 0) {
				for (j = 0; j < i - 1; j++) {
					if (i - j <= A[j] && dp[j] + 1 < dp[i]) {
						dp[i] = dp[j] + 1;
						bt[i] = j;
					}
				}
			} else {
				if (bt[i - 1] == -1)
					continue;

				dp[i] = dp[i - 1] + 1;
				bt[i] = i - 1;
				if (i - bt[i - 1] <= A[bt[i - 1]] && dp[i] > dp[bt[i - 1]] + 1) {
					dp[i] = dp[bt[i - 1]] + 1;
					bt[i] = bt[i - 1];
				}
			}
		}

		for (i = 0; i < A.length; i++) {
			System.out.print(bt[i] + " ");
		}

		System.out.println();

		for (i = 0; i < A.length; i++) {
			System.out.print(dp[i] + " ");
		}

		return (bt[A.length - 1] != -1);
	}

	public boolean canJump2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length < 1)
			return true;

		int[] bt = new int[A.length];
		int[] dp = new int[A.length];

		Arrays.fill(bt, -1);
		Arrays.fill(dp, A.length + 1);

		bt[0] = 0;
		dp[0] = 0;
		int i, j;
		for (i = 1; i < A.length; i++) {
			for (j = 0; j < i; j++) {
				if (i - j <= A[j] && dp[j] + 1 < dp[i]) {
					dp[i] = dp[j] + 1;
					bt[i] = j;
				}
			}
		}

		for (i = 0; i < A.length; i++) {
			System.out.print(bt[i] + " ");
		}

		System.out.println();

		for (i = 0; i < A.length; i++) {
			System.out.print(dp[i] + " ");
		}

		System.out.println("\n" + dp[A.length - 1]);
		return (bt[A.length - 1] != -1);
	}

	/**
	 * From penultimate to start, if the near one can reach the last, we could
	 * just check if we can reach this near number. No need to worry about some number
	 * would skip this number to directly reach the last, where it could also reach the near one!
	 * 
	 * @param A
	 * @return
	 */
	public boolean canJump3(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length < 2)
			return true;

		int flag = A.length - 1;
		for (int i = A.length - 2; i >= 0; i--) {
			if (flag - i <= A[i]) {
				flag = i;
			}
		}

		return (flag == 0);
	}

	/**
	 * ret: records how many steps required to reach index "last";
	 * last: the current maximum index we can reach
	 * cur: with ret+1 steps, the newly maximum index we can reach.
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret = 0;
        int last = 0;
        int cur = 0;
        
        for (int i = 0; i < A.length; i++){
            if (i > last){
                last = cur;
                ret++;
            }
            
            cur = Math.max(cur, i+A[i]);
        }
        
        return ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame jg = new JumpGame();
		System.out.println(jg.canJump2(new int[] { 2, 3, 1, 1, 4 }));
	}

}
