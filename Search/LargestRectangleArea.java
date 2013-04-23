package Search;

import java.util.Stack;

public class LargestRectangleArea {

	public int largestRectangleArea_old(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (height == null || height.length == 0)
			return 0;

		if (height.length == 1)
			return height[0];

		Stack<Integer> ints = new Stack<Integer>();
		ints.push(height[0]);

		int j = 1;
		int max = 0;

		while (j < height.length) {
			if (height[j] >= ints.peek()) {
				ints.push(height[j]);
				j++;
			} else {
				int count = 1;
				while (ints.size() > 0 && ints.peek() > height[j]) {
					max = Math.max(max, ints.pop() * count);
					count++;
				}

				for (int i = 0; i < count; i++) {
					ints.push(height[j]);
				}
				j++;
			}
		}

		if (ints.size() > 0) {
			int count = 1;
			while (ints.size() > 0) {
				max = Math.max(max, ints.pop() * count);
				count++;
			}
		}

		return max;
	}
	
	/* This version is much more comprehensible */
	public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height == null || height.length == 0)
    		return 0;

		if (height.length == 1)
			return height[0];

		Stack<Integer> ints = new Stack<Integer>();
		ints.push(height[0]);

		int j = 1;
		int max = 0;

		for (j = 1; j < height.length; j++){
			if (height[j] < ints.peek()){
				int count = 1;
				while (ints.size() > 0 && ints.peek() > height[j]){
					max = Math.max(max, ints.pop() * count);
					count++;
				}
				
				// Only push count - 1 height[j]s
				for (int i = 1; i < count; i++)
					ints.push(height[j]);
			}
			
			ints.push(height[j]);
		}

		if (ints.size() > 0) {
			int count = 1;
			while (ints.size() > 0) {
				max = Math.max(max, ints.pop() * count);
				count++;
			}
		}

		return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
