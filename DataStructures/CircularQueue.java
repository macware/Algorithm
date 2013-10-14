package DataStructures;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularQueue<T> {

	int head, tail;
	T[] items;
	int size;

	Lock lock;

	public CircularQueue(int size) {
		head = tail = 0;
		this.size = size;
		lock = new ReentrantLock();
	}

	public void enq(T item) {
		lock.lock();
		try {
			int len = 0;
			if (tail >= head)
				len = tail - head;
			else {
				len = size - head;
				len += tail;
			}

			if (len == size)
				throw new Exception("Full Queue");

			items[tail] = item;
			tail = (tail + 1) % size;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public T deq() {
		lock.lock();
		try {
			if (tail == head) {
				throw new Exception("Empty Queue");
			}

			T item = items[head];
			head = (head + 1) % size;
			return item;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
