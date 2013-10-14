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

	private int capacity;
	private Page head;
	private Map<Integer, Page> map;

	public LRU(int capacity) {
		this.capacity = capacity;
		head = new Page(-1, null);
		map = new HashMap<Integer, Page>();

	}

	public void insert(Page p) {
		if (map.containsKey(p.id))
			map.get(p.id).remove();

		if (map.size() >= capacity)
			evict();

		map.put(p.id, p);
		p.insert(head);
	}

	public Page get(int pagenum) {
		Page p = map.get(pagenum);
		if (p != null) {
			p.remove();
			p.insert(head);
		}

		return p;
	}

	private void evict() {
		if (capacity <= 0)
			return;

		Page p = head.pre;
		p.remove();
		map.remove(p.id);
	}

	public void clear(){
		Page cur = head.next;
		while (cur != head){
			cur.remove();
			map.remove(cur.id);
			cur = head.next;
		}
	}
	
	public void print() {
		Page cur = head.next;
		while (cur != head) {
			System.out.print(cur.id + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU lru = new LRU(2);
		lru.insert(new Page(1,null));
		lru.insert(new Page(2,null));
		lru.print();
		lru.insert(new Page(3,null));
		lru.print();
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
		lru.print();
		lru.clear();
		lru.print();
		System.out.println("done!");
	}
}
