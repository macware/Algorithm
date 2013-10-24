package DataStructures;

import java.util.*;

public class MinHeap<E extends Comparable<E>> {

	private List<E> h;

	public MinHeap() {
		h = new ArrayList<E>();
	}

	public MinHeap(E[] Es) {
		h = new ArrayList<E>();
		if (Es != null) {
			for (E e : Es)
				insert(e);
		}
	}

	public void insert(E node) {
		h.add(null);
		int pIdx, k = h.size() - 1;
		E parent;
		while (k > 0) {
			pIdx = (k - 1) / 2;
			parent = h.get(pIdx);

			if (node.compareTo(parent) >= 0)
				break;

			h.set(k, parent);
			k = pIdx;
		}

		h.set(k, node);
	}

	public E getMin() {
		if (h.isEmpty())
			return null;
		return h.get(0);
	}

	public boolean isEmpty() {
		return (h != null && h.isEmpty());
	}

	public E extractMin() {
		if (h.isEmpty())
			return null;

		E ret = h.get(0);
		E last = h.get(h.size() - 1);
		h.remove(h.size() - 1);
		if (h.size() == 0)
			return ret;

		int k = 0, child;
		while (k < h.size() - 1) {
			child = 2 * k + 1;
			if ((child < h.size() - 1)
					&& (h.get(child).compareTo(h.get(child + 1)) > 0))
				child++;
			if (h.get(child).compareTo(last) >= 0)
				break;
			h.set(k, h.get(child));
			k = child;
		}

		h.set(k, last);
		return ret;
	}

	// > 0 means, should put the newi in the front, high priority
	Comparator<Integer> comp = new Comparator<Integer>() {
		public int compare(Integer oldi, Integer newi) {
			return (newi - oldi);
			// if newi is larger than oldi, newi's priority is larger than oldi. newi will
			// be put in front of oldi, which is a descendent order.
		}
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] ins = new Integer[] { 2, 5, 1, 3 };
		MinHeap<Integer> heap = new MinHeap<Integer>(ins);
		// print keys in sorted order
//		while (!heap.isEmpty()) {
//			System.out.println(heap.extractMin());
//		}

		PriorityQueue<Integer> minh = new PriorityQueue<Integer>(10, heap.comp);
		for (Integer i : ins)
			minh.offer(i);
		while (!minh.isEmpty())
			System.out.println(minh.poll());

		Arrays.sort(ins,heap.comp);
		System.out.println(Arrays.asList(ins));
	}
}
