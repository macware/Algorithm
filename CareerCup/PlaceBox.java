package CareerCup;

import java.util.*;

public class PlaceBox {

	class Box{
		public int w;
		public int h;
		public int d;
		
		public boolean canBeAbove(Box b){
			return true;
		}
	}
	
	public ArrayList<Box> placing(Box[]boxes, Box bottom, HashMap<Box,ArrayList<Box>> stackMap){
		if (bottom != null && stackMap.containsKey(bottom)){
			return stackMap.get(bottom);
		}
		
		ArrayList<Box> maxStack = null;
		int maxHeight = 0;
		for (int i = 0; i < boxes.length; i++){
			if (boxes[i].canBeAbove(bottom)){
				ArrayList<Box> newStack = placing(boxes, boxes[i], stackMap);
				int newHeight = newStack.size(); // assume it is the height
				if (newHeight > maxHeight){
					maxStack = newStack;
					maxHeight = newHeight;
				}
			}
		}
		
		if (maxStack == null ) maxStack = new ArrayList<Box>();
		if (bottom != null) maxStack.add(0,bottom);
		/* we should store a map entry for this stack */
		stackMap.put(bottom, maxStack);
		
		/* we should return a copy to the caller */
		return (ArrayList<Box>)maxStack.clone();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
