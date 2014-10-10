package LinkedList;

public class LinkedListApp {
	public static void main(String[] args ){
		LinkedList ll = new LinkedList();
        ll.head = ll.head.getNext();
		ll.add(1);
		ll.add(4);
		ll.add(7);
		ll.add(8);
		ll.add(9);


		//ll.reverseListIteratively();
		System.out.println(ll.head.getData());

		//System.out.println(ll.toString());
	}

}
