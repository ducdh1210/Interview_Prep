package GenericHeap;

/**
 * CSE 373, Winter 2011, Jessica Miller
 * The BinaryHeap is an -generic- implementation of the PriorityQueue interface.  
 * This is a binary min-heap implementation of the priority queue ADT.
 */
import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> {
    /** Programing node: the appearance of T here means that somewhere in the class BinaryHeap, there will be some data
    ** structure that refers to object of type T. That data structure can be a linked node whose each node has a
    ** reference to object of type T, or an array whose each element is a object of type T, or even that data structure
    ** can be a object of type T directly */
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array; /* in this case, the data structure is an array whose each element is an object of type T */
    protected int size;
    
    /**
     * Constructs a new BinaryHeap.
     */
    @SuppressWarnings("unchecked")
	public BinaryHeap () {
        // Java doesn't allow construction of arrays of placeholder data types 
        array = (T[])new Comparable[DEFAULT_CAPACITY];  /** interesting point about polymorphism here: first, we create
         new array of type Comparable here. Then we downcast it into array of type T. Why are you allow to do that?
         It is because in the declaration of the class, we said that "BinaryHeap< T extends Comparable<T> >", which
         means that whatever the data structure that contains object of type T, that object of type T is the subclass of
          type Comparable */
        size = 0;
    }
    
    
    /**
     * Adds a value to the min-heap.
     */
    public void add(T value) {
        // grow array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }        
        
        // place element into heap at bottom
        size++;
        int index = size;
        array[index] = value;
        
        bubbleUp();
    }
    
    
    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    
    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        
        return array[1];
    }

    
    /**
     * Removes and returns the minimum element in the heap.
     */
    public T remove() {
    	// what do want return?
    	T result = peek();
    	
    	// get rid of the last leaf/decrement
    	array[1] = array[size];
    	array[size] = null;
    	size--;
    	
    	bubbleDown();
    	
    	return result;
    }
    
    
    /**
     * Returns a String representation of BinaryHeap with values stored with 
     * heap structure and order properties.
     */
    public String toString() {
        return Arrays.toString(array);
    }

    
    /**
     * Performs the "bubble down" operation to place the element that is at the 
     * root of the heap in its correct place so that the heap maintains the 
     * min-heap order property.
     */
    protected void bubbleDown() {
        int index = 1;
        
        // bubble down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);
            
            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index) && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            } 
            
            if (array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }
            
            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }        
    }
    
    
    /**
     * Performs the "bubble up" operation to place a newly inserted element 
     * (i.e. the element that is at the size index) in its correct place so 
     * that the heap maintains the min-heap order property.
     */
    protected void bubbleUp() {
        int index = this.size;
        
        while (hasParent(index)  && (parent(index).compareTo(array[index]) > 0)) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
        bubbleDown();
    }
    
    
    protected boolean hasParent(int i) {
        return i > 1;
    }
    
    
    protected int leftIndex(int i) {
        return i * 2;
    }
    
    
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    
    protected T parent(int i) {
        return array[parentIndex(i)];
    }
    
    
    protected int parentIndex(int i) {
        return i / 2;
    }
    
    
    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }
    
    
    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;        
    }
    
    public static void main(String[] args){
    	BinaryHeap<Integer> heapObj = new BinaryHeap<Integer>();
    	heapObj.add(2);
    	heapObj.add(8);
    	heapObj.add(10);
    	heapObj.add(17);
    	heapObj.add(5);
    	heapObj.add(3);
    	heapObj.add(9);
    	heapObj.add(6);
    	heapObj.add(11);
    	//heapObj.add(4);
    	
    	System.out.println(heapObj.toString());
    	
    }
    
}