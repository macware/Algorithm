package Search;

import java.util.*;
import java.util.Arrays;

public class SolveSudoku {
	boolean[][] rowChecker, colChecker, blockChecker;
	public boolean res;

	public boolean checkValid(int i, int j, int t) {
		if (rowChecker[i][t] || colChecker[j][t]
				|| blockChecker[i / 3 * 3 + j / 3][t])
			return false;

		return true;
	}

	public void setValid(char[][] board, int i, int j, int t) {
		board[i][j] = (char) ('1' + t);
		rowChecker[i][t] = true;
		colChecker[j][t] = true;
		blockChecker[i / 3 * 3 + j / 3][t] = true;
	}

	public void reset(char[][] board, int i, int j, int t) {
		rowChecker[i][t] = false;
		colChecker[j][t] = false;
		blockChecker[i / 3 * 3 + j / 3][t] = false;
	}

	public boolean search(char[][] board, ArrayList<Integer> slots, int n) {
		if (n == slots.size())
			return true;

		int pos = slots.get(n);
		int i = pos / 9;
		int j = pos % 9;

		for (int t = 0; t < 9; t++) {
			if (checkValid(i, j, t)) {
				setValid(board, i, j, t);
				if (search(board, slots, n + 1)) {
					// reset(board, i, j, t);
					return true;
				}
				reset(board, i, j, t);
			}
		}

		return false;
	}

	public void solveSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> slots = new ArrayList<Integer>();
		rowChecker = new boolean[9][9];
		colChecker = new boolean[9][9];
		blockChecker = new boolean[9][9];

		int t;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					slots.add(i * 9 + j);
					continue;
				}

				t = board[i][j] - '1';
				rowChecker[i][t] = true;
				colChecker[j][t] = true;
				blockChecker[i / 3 * 3 + j / 3][t] = true;
			}

		res = search(board, slots, 0);
	}

	public void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean solving(int n, ArrayList<Integer> slots, char[][] board,
			int[] rowchecker, int[] colchecker, int[] boxchecker,
			Map<Integer, Integer> map, int all) {
		if (n == slots.size())
			return true;

		int i = slots.get(n) / board.length;
		int j = slots.get(n) % board.length;
		int box = i / 3 * 3 + j / 3;

		int p, pos = all & (~(rowchecker[i] | colchecker[j] | boxchecker[box]));
		while (pos != 0) {
			p = pos & (~(pos - 1));
			rowchecker[i] |= p;
			colchecker[j] |= p;
			boxchecker[box] |= p;
			board[i][j] = (char)(map.get(p) + '1');
			
			if (solving(n + 1, slots, board, rowchecker, colchecker,
					boxchecker, map, all))
				return true;
			
			rowchecker[i] &= ~p;
			colchecker[j] &= ~p;
			boxchecker[box] &= ~p;
			board[i][j] = '.';
			
			pos &= (pos - 1);
		}

		return false;
	}

	public void solveSudoku2(char[][] board) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (board == null || board.length == 0
				|| board.length != board[0].length)
			return;

		int[] rowchecker = new int[board.length];
		int[] colchecker = new int[board.length];
		int[] boxchecker = new int[board.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> slots = new ArrayList<Integer>();

		int i, j, c;
		for (i = 0; i < board.length; i++) {
			map.put(1 << i, i);
			for (j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					slots.add(i * board.length + j);
					continue;
				}

				c = 1 << (board[i][j] - '1');
				rowchecker[i] |= c;
				colchecker[j] |= c;
				boxchecker[i / 3 * 3 + j / 3] |= c;
			}
		}

		int all = (1 << board.length) - 1;
		res = solving(0, slots, board, rowchecker, colchecker, boxchecker, map, all);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[9][9];
		String[] strs1 = new String[] { "519748632", "783652419", "426139875",
				"357986241", "264317598", "198524367", "975863124",
				"832491756", "641275983" };

		String[] strs2 = new String[] { "53..7....", "6..195...", ".98....6.",
				"8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
				"...419..5", "....8..79" };

		HashSet<Integer> empty = new HashSet<Integer>(Arrays.asList(72, 73, 74,
				75, 76, 77, 78, 79));

		String[] strs = strs2;
		for (int i = 0; i < strs.length; i++)
			for (int j = 0; j < strs[i].length(); j++)
				board[i][j] = strs[i].charAt(j);

		SolveSudoku ss = new SolveSudoku();
		System.out.println("Origin: ");
		ss.print(board);

		if (strs == strs1) {
			for (Integer it : empty) {
				board[it / 9][it % 9] = '.';
			}
			System.out.println("Changed: ");
			ss.print(board);
		}

		ss.solveSudoku2(board);
		System.out.println("Solve: " + ss.res);
		ss.print(board);
	}

}
