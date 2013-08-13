package Search;

public class MoveRobot {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;

		int[] pre, cur;
		pre = new int[obstacleGrid[0].length];
		cur = new int[obstacleGrid[0].length];
		pre[0] = 1;

		int i, j;
		for (i = 0; i < obstacleGrid.length; i++) {
			for (j = 0; j < pre.length; j++) {
				cur[j] = pre[j];
				if (j > 0)
					cur[j] += cur[j - 1];

				if (obstacleGrid[i][j] == 1)
					cur[j] = 0;
			}

			int[] tmp = cur;
			cur = pre;
			pre = tmp;
		}

		return pre[pre.length - 1];
	}

	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m <= 0 || n <= 0)
			return 0;

		if (m == 1 || n == 1)
			return 1;

		int d = m + n - 2;
		long divident = 1, divisor = 1;
		int i;
		for (i = 0; i < m - 1; i++) {
			divident *= (d - i);
			divisor *= (i + 1);
		}
		
		return (int)(divident / divisor);
	}
	
	public int uniquePaths2(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m <= 0 || n <= 0)
			return 0;

		if (m == 1 || n == 1)
			return 1;

		int[] pre, cur;
		pre = new int[n];
		cur = new int[n];
		pre[0] = 1;

		int i, j;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				cur[j] = pre[j];
				if (j > 0)
					cur[j] += cur[j - 1];
			}

			int[] tmp = cur;
			cur = pre;
			pre = tmp;
		}

		return pre[n-1];
	}

	public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
            
        int[] pre,cur;
        pre = new int[grid[0].length];
        cur = new int[grid[0].length];
        
        int i,j;
        pre[0] = grid[0][0];
        for (i = 1; i < pre.length; i++)
            pre[i] = pre[i-1] + grid[0][i];
        
        
        for (i = 1; i < grid.length; i++){
            for (j = 0; j < cur.length; j++){
                cur[j] = pre[j];
                if (j > 0 && cur[j-1] < pre[j])
                    cur[j] = cur[j-1];
                cur[j] += grid[i][j];
            }
            
            int[] tmp = cur;
            cur = pre;
            pre = tmp;
        }
        
        return pre[pre.length-1];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveRobot mr = new MoveRobot();
		System.out.println(mr.uniquePaths2(10, 10));
	}

}
