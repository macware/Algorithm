package DataStructures;

import java.util.*;

public class CircularArray<T> implements Iterable<T> {

	private T[] items;
	private int head;
	private int size;

	public CircularArray(int size) {
		items = (T[])(new Object[size]);
		this.size = size;
		head = 0;
	}

	private int convert(int idx) {
		if (idx < 0){
			idx %= size;
			idx += size;
		}

		return (head + idx) % size;
	}

	public T get(int idx) {
		return items[convert(idx)];
	}

	public void set(int idx, T item) {
		items[convert(idx)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIterator<T>();
	}

	private class CircularArrayIterator<T> implements Iterator<T> {

		private int cur;

		public CircularArrayIterator() {
			cur = -1;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (cur < size - 1)
				return true;
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			cur++;
			return (T)items[cur];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			if (cur == -1) {
				return;
			}
			items[cur] = null;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArray<Integer> arr = new CircularArray<>(5);
		arr.set(5, 1);
		arr.set(3, 2);
		
		Iterator<Integer> it = arr.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}

}
