package LinkedList;
public class LinkedList<T> {
    /* only need to store a single pointer to the node at the head
     * of the list.
     * The pointer is null if the list is empty.
     * Also record the size of the list.
     */
    protected Node<T> head;
    /* invariant: size is the number of nodes in the list pointed to by head */
    protected int size;

    /* no-arguments default constructor creates an empty list */
    public LinkedList() {
        head = null;		// start with an empty list
        size = 0;
    }

    /* accessor method */
    public int size() {
        return size;
    }

    /* @param	value to add to the end of the list
     */
    public void add(T value) {
        head = addAtEnd(head, value);
        size++;
    }

    /* @param	node of the list to which the value should be added
     * @param	value to add to the end of the list
     */
    private Node<T> addAtEnd(Node<T> node, T value) {
        if (node == null) {	// special case
            return new Node<T>(value, null);
        } else if (node.getNext() == null) { // other special case
            node.setNext(new Node<T>(value, null));
        } else {
            addAtEnd(node.getNext(), value);
        }
        return node;
    }

    /* iterative implementation of the same method
     * @param	value to add to the end of the list
     */
    public void add2(T value) {
        if (head == null) {
            head = new Node<T>(value, null);
        } else {
            Node<T> node = head; // guaranteed not to be null initially
            while (node.getNext() != null) {
                node = node.getNext(); // guaranteed not to be null here
            }
            // now, node.getNext() is guaranteed to be null
            // similar to the second special case in addAtEnd
            node.setNext(new Node<T>(value, null));
        }
        size++;
    }

    /* @param	position of item to be removed
     * @throws	BadItemCountException if this is not a valid position
     * 		position is 1-based, so position = 1 removes the head
     */
    public void remove(int position) throws Exception {
        if ((position < 1) || (position > size)) {
            throw new
                    Exception("invalid position " + position +
                    ", only 1.." + size + " available");
        }
        if (position == 1) {
            head = head.getNext();
        } else {
            Node<T> node = head;
            for (int i = 2; i < position; i++) {
                node = node.getNext();
            }
            // set this node's "next" pointer to refer to the
            // node that is after the next
            node.setNext(node.getNext().getNext());
        }
        size--;			// one less item
    }

    /* convert the list to a printable string
     * @return	a string representing the stack
     */
    public String toString() {
        return toString(head);
    }
    private String toString(Node<T> node) {
        if (node == null) {
            return "";
        } else {
            return node.getData() + "\n" + toString(node.getNext());
        }
    }

    /* unit test -- test all the methods in this class
     * @param	ignored
     */
    public static void main(String[] args) {
	/* create two empty lists, make sure they print out correctly */
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        System.out.println("list1 = '" + list1 + "', list2 = '" + list2 + "'");
        System.out.println("list1.size() = " + list1.size() +
                ", list2.size() = " + list2.size());

	/* insert some items, keep checking */
        list1.add("hello");
        list1.add("world");
        list2.add("foo");
        list2.add("bar");
        list2.add("baz");
        System.out.println("list1 = '" + list1 + "', list2 = '" + list2 + "'");
        System.out.println("list1.size() = " + list1.size() +
                ", list2.size() = " + list2.size());

	/* remove an item at an invalid position */
        boolean caught = false;
        try {
            list2.remove(4);
        } catch (Exception e) {
            caught = true;
        }
        if (! caught) {
            System.out.println("error: no exception for invalid remove");
            System.out.println("list1 = '" + list1 +
                    "', list2 = '" + list2 + "'");
        }
        System.out.println("list1 = '" + list1 + "', list2 = '" + list2 + "'");

	/* remove some items at valid positions */
        try {
            list1.remove(1);
            System.out.println("list1 = '" + list1 +
                    "', list2 = '" + list2 + "'");
            list2.remove(2);
            System.out.println("list1 = '" + list1 +
                    "', list2 = '" + list2 + "'");
            list2.remove(2);
            System.out.println("list1 = '" + list1 +
                    "', list2 = '" + list2 + "'");
        } catch (Exception e) {
            System.out.println("caught unexpected exception " + e +
                    ", list1 = '" + list1 + ", list2 = " + list2);
        }
        System.out.println("list1.size() = " + list1.size() +
                ", list2.size() = " + list2.size());
    }
}

class Node<T> {
    // reference to the next node in the chain,
    // or null if there isn't one.
    Node<T> next;
    // data carried by this node.
    // could be of any type you need.
    Object data;


    // Node constructor
    public Node(Object _data) {
        next = null;
        data = _data;
    }

    // another Node constructor if we want to
    // specify the node to point to.
    public Node(Object _data, Node<T> _next) {
        next = _next;
        data = _data;
    }

    // these methods should be self-explanatory
    public Object getData() {
        return data;
    }

    public void setData(Node<T> _data) {
        data = _data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> _next) {
        next = _next;
    }
 }



//public class LinkedList {
//	// reference to the head node.
//    public Node head;
//    private int listCount;
//
//    // LinkedList constructor
//    public LinkedList()
//    {
//        // this is an empty list, so the reference to the head node
//        // is set to a new node with no data
//        head = new Node(null);
//        listCount = 0;
//    }
//
//    public void add(Object data)
//    // post: appends the specified element to the end of this list.
//    {
//        Node temp = new Node(data);
//        Node current = head;
//        // starting at the head node, crawl to the end of the list
//        while(current.getNext() != null)
//        {
//            current = current.getNext();
//        }
//        // the last node's "next" reference set to our new node
//        current.setNext(temp);
//        listCount++;// increment the number of elements variable
//    }
//
//    public void add(Object data, int index)
//    // post: inserts the specified element at the specified position in this list.
//    {
//        Node temp = new Node(data);
//        Node current = head;
//        // crawl to the requested index or the last element in the list,
//        // whichever comes first
//        for(int i = 1; i < index && current.getNext() != null; i++)
//        {
//            current = current.getNext();
//        }
//        // set the new node's next-node reference to this node's next-node reference
//        temp.setNext(current.getNext());
//        // now set this node's next-node reference to the new node
//        current.setNext(temp);
//        listCount++;// increment the number of elements variable
//    }
//
//    public Object get(int index)
//    // post: returns the element at the specified position in this list.
//    {
//        // index must be 1 or higher
//        if(index <= 0)
//            return null;
//
//        Node current = head.getNext();
//        for(int i = 1; i < index; i++)
//        {
//            if(current.getNext() == null)
//                return null;
//
//            current = current.getNext();
//        }
//        return current.getData();
//    }
//
//    public boolean remove(int index)
//    // post: removes the element at the specified position in this list.
//    {
//        // if the index is out of range, exit
//        if(index < 1 || index > size())
//            return false;
//
//        Node current = head;
//        for(int i = 1; i < index; i++)
//        {
//            if(current.getNext() == null)
//                return false;
//
//            current = current.getNext();
//        }
//        current.setNext(current.getNext().getNext());
//        listCount--; // decrement the number of elements variable
//        return true;
//    }
//
//    public int size()
//    // post: returns the number of elements in this list.
//    {
//        return listCount;
//    }
//
//    public String toString()
//    {
//        Node current = head.getNext();
//        String output = "";
//        while(current != null)
//        {
//            output += "[" + current.getData().toString() + "]";
//            current = current.getNext();
//        }
//        return output;
//    }
//
//    public void reverseListIteratively (){
//    	if (head == null || head.next == null)
//    		return;  //empty or just one node in list
//    	Node Second = head.next;
//    	//store third node before we change
//    	Node Third = Second.next;
//    	//Second's next pointer
////    	Second.next = head;  //second now points to head
////    	head.next = null;  //change head pointer to NULL
//
//    	Second.next = null;
//    	head.next = Third;
//
//    	//only two nodes, which we already reversed
//    	if (Third == null)
//    		return;
//
//    	Node CurrentNode = Third;
//    	Node PreviousNode = Second;
//
//    	while (CurrentNode != null){
//    		Node NextNode = CurrentNode.next;
//    		CurrentNode.next = PreviousNode;
//    		/*  repeat the process, but have to reset
//         	the PreviousNode and CurrentNode
//    		*/
////    		System.out.println(CurrentNode.data.toString());
//    		PreviousNode = CurrentNode;
//    		CurrentNode = NextNode;
//    	}
//    	head = new Node(null);
//    	head.setNext(PreviousNode);
//    }
//
//    public class Node
//    {
//        // reference to the next node in the chain,
//        // or null if there isn't one.
//        Node next;
//        // data carried by this node.
//        // could be of any type you need.
//        Object data;
//
//
//        // Node constructor
//        public Node(Object _data)
//        {
//            next = null;
//            data = _data;
//        }
//
//        // another Node constructor if we want to
//        // specify the node to point to.
//        public Node(Object _data, Node _next)
//        {
//            next = _next;
//            data = _data;
//        }
//
//        // these methods should be self-explanatory
//        public Object getData()
//        {
//            return data;
//        }
//
//        public void setData(Object _data)
//        {
//            data = _data;
//        }
//
//        public Node getNext()
//        {
//            return next;
//        }
//
//        public void setNext(Node _next)
//        {
//            next = _next;
//        }
//    }
//
//}
