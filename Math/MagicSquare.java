package Math;

public class MagicSquare {

	public int[][] magicSquare(int n) {
		if (n <= 0 || n % 2 == 0)
			return null;

		int[][] res = new int[n][n];
		int row = 0;
		int col = n / 2;
		res[row][col] = 1;

		for (int i = 2; i <= n * n; i++) {
			if (res[(row - 1 + n) % n][(col + 1) % n] == 0) {
				row = (row - 1 + n) % n;
				col = (col + 1) % n;
			} else
				row = (row + 1) % n;
			res[row][col] = i;
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicSquare ms = new MagicSquare();
		int[][] res = ms.magicSquare(5);
		for(int i = 0; i < res.length; i++){
			for (int j = 0; j < res[0].length; j++)
				System.out.print(res[i][j]+" ");
			System.out.println();
		}
	}

}
