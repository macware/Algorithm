package CareerCup;

public class Page {

	public int id;
	public Object o;
	
	public Page pre;
	public Page next;
	
	public Page(int id, Object obj){
		this.id = id;
		o = obj;
		pre = next = this;
	}
	
	public void insert(Page list){
		next = list.next;
		list.next.pre = this;
		list.next = this;
		pre = list;
	}
	
	public void remove(){
		if (next == null)
			return;
		pre.next = next;
		next.pre = pre;
		pre = next = this;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
