package DP;
import java.util.*;
public class PlaceQueens {

	private int gridSize;
	
	public PlaceQueens(int grid){
		gridSize = grid;
	}
	
	private void placing(int row, Integer[] cols, ArrayList<Integer[]> result){
		if (row == gridSize){
			result.add(cols.clone());
		} else {
			for (int col = 0; col < gridSize; col++){
				if (checkValid(row, col, cols)){
					cols[row] = col;
					placing(row + 1, cols, result);
				}
			}
		}
	}
	
	private boolean checkValid(int row, int col, Integer[] cols){
		for (int row2 = 0; row2 < row; row2++){
			int col2 = cols[row2];
			if (col2 == col)
				return false;
			
			if (Math.abs(col2-col2) == (row - row2))
				return false;
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
