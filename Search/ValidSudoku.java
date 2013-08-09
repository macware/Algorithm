package Search;
import java.util.*;
public class ValidSudoku {

	public boolean isValidSudoku1(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[] exist = new boolean[9];
        int i,j,t;
        
         // check row
        for (i = 0; i < 9; i++){
            Arrays.fill(exist,false);
            for (j = 0; j < 9; j++){
                if (board[i][j] == '.')
                    continue;
                    
                t = board[i][j] - '1';
                if (exist[t])
                    return false;
                exist[t] = true;
            }
        }
        
         // check column
        for (i = 0; i < 9; i++){
            Arrays.fill(exist,false);
            for (j = 0; j < 9; j++){
                if (board[i][j] == '.')
                    continue;
                
                t = board[j][i] - '1';
                if (exist[t])
                    return false;
                exist[t] = true;
            }
        }
        
        // check block
        int x,y;
        for (i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                Arrays.fill(exist,false);
                for (x = 0; x < 3; x++)
                    for (y = 0; y < 3; y++){
                        t = board[i*3+x][j*3+y];
                        if (t == '.')
                            continue;
                        t = t - '1';
                        if (exist[t])
                            return false;
                        exist[t] = true;
                    }
            }
        }
        
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
