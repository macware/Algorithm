package Search;

import java.util.*;

public class MaximumRectangle {

	public int largestRectangleArea(int[] height) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (height == null || height.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, max = 0, tmp;

		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i])
				stack.push(i++);
			else {
				tmp = stack.pop();
				int len = i;
				if (!stack.isEmpty())
					len -= (stack.peek() + 1);
				max = Math.max(max, height[tmp] * len);
			}
		}

		while (!stack.isEmpty()) {
			tmp = stack.pop();
			int len = i;
			if (!stack.isEmpty())
				len -= (stack.peek() + 1);
			max = Math.max(max, height[tmp] * len);
		}

		return max;
	}
    
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
            
        int[][] tmp = new int[matrix.length][matrix[0].length];
        int i,j;
        for (i = 0; i < matrix.length; i++){
            for (j = 0; j < matrix[0].length; j++){
                tmp[i][j] = matrix[i][j] - '0';
                if (i > 0 && matrix[i][j] == '1')
                    tmp[i][j] += tmp[i-1][j];
            }
        }
        
        int max = 0;
        for (i = 0; i < matrix.length; i++)
            max = Math.max(max, largestRectangleArea(tmp[i]));
            
        return max;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
