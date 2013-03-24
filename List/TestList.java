package List;

public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l = new List();
		for (int i = 0; i < 10; i++)
			l.appendNode(i);
		System.out.println(l.getNode(4).data);
		//l.printList();
		
		l.deleteNode(4);
		l.deleteNode(9);
		
		System.out.println(l.getEnd().data);
		l.printList();
	}

}
