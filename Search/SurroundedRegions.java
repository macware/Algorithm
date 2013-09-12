package Search;

import java.util.*;

public class SurroundedRegions {

	public void checking(char[][] board, int x, int y) {
		checking_bfs2(board, x, y);
	}

	public void checking_dfs(char[][] board, int x, int y) {
		board[x][y] = '+';

		if (x > 0 && board[x - 1][y] == 'O')
			checking_dfs(board, x - 1, y);

		if (x < board.length - 1 && board[x + 1][y] == 'O')
			checking_dfs(board, x + 1, y);

		if (y > 0 && board[x][y - 1] == 'O')
			checking_dfs(board, x, y - 1);

		if (y < board[0].length - 1 && board[x][y + 1] == 'O')
			checking_dfs(board, x, y + 1);
	}

	public void checking_bfs2(char[][] board, int x, int y) {
		Queue<Integer> xque = new LinkedList<Integer>();
		Queue<Integer> yque = new LinkedList<Integer>();
		xque.add(x);
		yque.add(y);

		while (!xque.isEmpty()) {
			x = xque.remove();
			y = yque.remove();
			board[x][y] = '+';

			if (x > 0 && board[x - 1][y] == 'O') {
				xque.add(x - 1);
				yque.add(y);
			}

			if (x < board.length - 1 && board[x + 1][y] == 'O') {
				xque.add(x + 1);
				yque.add(y);
			}

			if (y > 0 && board[x][y - 1] == 'O') {
				xque.add(x);
				yque.add(y - 1);
			}

			if (y < board[0].length - 1 && board[x][y + 1] == 'O') {
				xque.add(x);
				yque.add(y + 1);
			}
		}
	}

	public void checking_bfs(char[][] board, int x, int y) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(x * board[0].length + y);

		int n;
		while (!que.isEmpty()) {
			n = que.remove();
			x = n / board[0].length;
			y = n % board[0].length;
			board[x][y] = '+';

			if (x > 0 && board[x - 1][y] == 'O')
				que.add(n - board[0].length);

			if (x < board.length - 1 && board[x + 1][y] == 'O')
				que.add(n + board[0].length);

			if (y > 0 && board[x][y - 1] == 'O')
				que.add(n - 1);

			if (y < board[0].length - 1 && board[x][y + 1] == 'O')
				que.add(n + 1);
		}
	}

	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length == 0 || board[0].length == 0)
			return;

		int i, j;
		for (i = 0; i < board.length; i++) {
			if (board[i][0] == 'O')
				checking(board, i, 0);
			if (board[i][board[0].length - 1] == 'O')
				checking(board, i, board[0].length - 1);
		}

		for (j = 1; j < board[0].length - 1; j++) {
			if (board[0][j] == 'O')
				checking(board, 0, j);
			if (board[board.length - 1][j] == 'O')
				checking(board, board.length - 1, j);
		}

		for (i = 0; i < board.length; i++)
			for (j = 0; j < board[0].length; j++) {
				if (board[i][j] == '+')
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions sr = new SurroundedRegions();
		String[] strs = new String[] { "XOOOOOOOOOOOOOOOOOOO",
				"OXOOOOXOOOOOOOOOOOXX", "OOOOOOOOXOOOOOOOOOOX",
				"OOXOOOOOOOOOOOOOOOXO", "OOOOOXOOOOXOOOOOXOOX",
				"XOOOXOOOOOXOXOXOXOXO", "OOOOXOOXOOOOOXOOXOOO",
				"XOOOXXXOXOOOOXXOXOOO", "OOOOOXXXXOOOOXOOXOOO",
				"XOOOOXOOOOOOXXOOXOOX", "OOOOOOOOOOXOOXOOOXOX",
				"OOOOXOXOOXXOOOOOXOOO", "XXOOOOOXOOOOOOOOOOOO",
				"OXOXOOOXOXOOOXOXOXOO", "OOXOOOOOOOXOOOOOXOXO",
				"XXOOOOOOOOXOXXOOOXOO", "OOXOOOOOOOXOOXOXOXOO",
				"OOOXOOOOOXXXOOXOOOXO", "OOOOOOOOOOOOOOOOOOOO",
				"XOOOOXOOOXXOOXOXOXOO" };

		char[][] board = new char[strs.length][strs[0].length()];
		for (int i = 0; i < strs.length; i++)
			for (int j = 0; j < strs[0].length(); j++)
				board[i][j] = strs[i].charAt(j);

		sr.solve(board);
		System.out.println(board[0][0]);
	}
}
