package DataStructures;
import java.util.*;

// Chapter 3.6
public class SortStack {

	public Stack<Integer> sortAsc(Stack<Integer> src){
		Stack<Integer> buf = new Stack<Integer>();
		while (!src.isEmpty()){
			int tmp = src.pop();
			while (!buf.isEmpty() && buf.peek() > tmp){
				src.push(buf.pop());
			}
			buf.push(tmp);
		}
		return buf;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
