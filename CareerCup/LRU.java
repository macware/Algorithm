package CareerCup;

import java.util.*;
import java.util.Map.*;

public class LRU {

	public class LRUCache<K, V> extends LinkedHashMap<K, V> {
		private int capacity;

		public LRUCache(int size) {
			super(size + 1, 1.0f, true);
			capacity = size;
		}

		protected boolean removeEldestEntry(Entry entry) {
			return (size() > capacity);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ll = new LinkedList<Integer>();
	}

}
