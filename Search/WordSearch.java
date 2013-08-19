package Search;

public class WordSearch {

	public boolean dfs(char[][] board, int x, int y, boolean[][] used,
			String word) {
		
		if (used[x][y] || board[x][y] != word.charAt(0))
			return false;

		if (word.length() == 1)
			return true;
		
		String next = word.substring(1);
		used[x][y] = true;
		if (x != 0 && dfs(board, x - 1, y, used, next))
			return true;

		if (y != board[0].length - 1 && dfs(board, x, y + 1, used, next))
			return true;

		if (x != board.length - 1 && dfs(board, x + 1, y, used, next))
			return true;

		if (y != 0 && dfs(board, x, y - 1, used, next))
			return true;

		used[x][y] = false;

		return false;
	}

	public boolean dfs_2(char[][] board, int x, int y, boolean[][] used, String word){
        if (word.length() == 0)
            return true;
            
        if ( x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
            
        if (used[x][y] || board[x][y] != word.charAt(0))
            return false;
            
        String next = word.substring(1);
        used[x][y] = true;
        boolean ret = dfs(board, x-1, y, used, next)
                    || dfs(board, x, y+1, used, next)
                    || dfs(board, x+1, y, used, next)
                    || dfs(board, x, y-1, used, next);
        
        used[x][y] = false;
        
        return ret;
    }
	
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;

		if (word.length() == 0)
			return true;
		
		boolean[][] used = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, i, j, used, word))
					return true;
			}
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
