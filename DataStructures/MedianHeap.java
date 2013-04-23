package DataStructures;

import java.util.*;

public class MedianHeap {

	PriorityQueue<Integer> maxHeap, minHeap;
	
	Comparator<Integer> maxHeapComp = new Comparator<Integer>(){
		public int compare(Integer i1,Integer i2){
			return i2.compareTo(i1);
		}
	};
	
	Comparator<Integer> minHeapComp = new Comparator<Integer>(){
		public int compare(Integer i1,Integer i2){
			return i1.compareTo(i2);
		}
	};
	
	public MedianHeap(){
		maxHeap = new PriorityQueue<Integer>(10, maxHeapComp);
		minHeap = new PriorityQueue<Integer>(10, minHeapComp);
	}
	
	public void addNew(Integer i){
		if (maxHeap.size() == minHeap.size()){
			if (minHeap.peek() != null && i > minHeap.peek()){
				maxHeap.offer(minHeap.poll());
				minHeap.offer(i);
			}else{
				maxHeap.offer(i);
			}
		}else{
			if (i < maxHeap.peek()){
				minHeap.offer(maxHeap.peek());
				maxHeap.offer(i);
			}else{
				minHeap.offer(i);
			}
		}
	}
	
	public double getMedian(){
		if (maxHeap.size() == 0)
			return 0;
		
		if (maxHeap.size() == minHeap.size()){
			return (maxHeap.peek() + minHeap.peek())/2.0;
		}
		
		return maxHeap.peek();
	}
	public void test(){
		maxHeap.offer(3);
		maxHeap.offer(2);
		maxHeap.offer(1);
		maxHeap.offer(4);
		maxHeap.offer(5);
		
		int size = maxHeap.size();
		for (int i = 0; i < size; i++){
			System.out.println(maxHeap.poll());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianHeap mh = new MedianHeap();
		mh.addNew(2);
		mh.addNew(3);
		mh.addNew(1);
		mh.addNew(6);
		mh.addNew(4);
		mh.addNew(5);
		
		System.out.println(mh.getMedian());
		
		
	}

}
