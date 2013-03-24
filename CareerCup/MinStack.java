package CareerCup;

import java.util.*;

// Chapter 3, if a state can be tracked as time goes by, record it!
public class MinStack extends Stack<Integer> {

	private Stack<Integer> mins;

	public MinStack() {
		mins = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min()) {
			mins.push(value);
		}

		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			mins.pop();
		}

		return value;
	}

	public int min() {
		if (mins.isEmpty()) {
			return Integer.MAX_VALUE;
		}

		return mins.peek();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinStack ms = new MinStack();
		ms.push(2);
		ms.push(3);
		ms.push(4);
		ms.push(1);
		
		System.out.print(ms.min());
	}

}
