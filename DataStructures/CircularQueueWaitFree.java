package DataStructures;

import java.util.Iterator;

public class CircularQueueWaitFree<T> implements Iterable<T> {
	int head, tail;
	int size;
	T[] items;

	public CircularQueueWaitFree(int size) {
		head = tail = 0;
		this.size = size;
		items = (T[]) new Object[size];
	}

	public void enq(T item) {
		if (tail - head == size)
			return;
		items[tail % size] = item;
		tail++;
	}

	public T deq() {
		if (tail - head == 0)
			return null;
		T ret = items[head % size];
		head++;
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private class CircularQueueIterator<E> implements Iterator<E> {
		private int cur;

		public CircularQueueIterator() {
			cur = -1;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (cur < (tail - head - 1))
				return true;
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			cur++;
			return (E) items[(head + cur) % size];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			try {
				throw new Exception("Operation not supported");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
