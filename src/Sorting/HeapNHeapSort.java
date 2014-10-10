package Sorting;


public class HeapNHeapSort {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<Integer>(10);
		heap.enqueue(4);
		heap.enqueue(6);
		heap.enqueue(9);	
		heap.enqueue(3);
		heap.enqueue(12);
		heap.print();
		System.out.println(heap);
		heap.dequeue();	
		System.out.println(heap);
		
		Heap<Integer> heap1 = new Heap<Integer>(new Integer[]{ 5, 2, 6, 8, 4, 9});
		heap1.makeItHeap();
		System.out.println(heap1);
		System.out.println(heap1.isHeap());
		
		Integer[] sorted = (Integer[]) heap1.heapSort(new Integer[]{ 5, 2, 6, 8, 4, 9});
		for(int i = 0; i < sorted.length; i++)
			System.out.print( sorted[i] + " " );
	}
}

class Heap<T>{
	T[] heap;
	int lastIndex, arrayCap;
	
	@SuppressWarnings("unchecked")
	public Heap(int cap){
		heap = (T[]) new Object[cap];
		arrayCap = cap;
		lastIndex = -1;
	}
	
	public Heap(T[] array){
		heap = array;
		arrayCap = array.length;
		lastIndex = -1;
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != null) lastIndex++;
		}		
	}
	
	public void makeItHeap()
	{
		for(int i = (lastIndex+1)/2-1; i >= 0; i--)
		{
			reheapDown(heap[i], i);
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean recIsHeap(int cursor)
	{
		if(cursor == lastIndex) return true;
		else if( cursor*2+1 <= lastIndex && cursor*2+2 <= lastIndex )
		{
			if( ((Comparable<T>)heap[cursor]).compareTo(heap[cursor*2+1]) < 0 || ((Comparable<T>)heap[cursor]).compareTo(heap[cursor*2+2]) < 0) return false;
			else return recIsHeap(2*cursor + 1) && recIsHeap(2*cursor + 2);
		}
		else if ( cursor*2+1 <= lastIndex )
		{
			if( ((Comparable<T>)heap[cursor]).compareTo(heap[cursor*2+1]) < 0 ) return false;
			else return recIsHeap(2*cursor + 1);
		}
		else if ( cursor*2+2 <= lastIndex )
		{
			if( ((Comparable<T>)heap[cursor]).compareTo(heap[cursor*2+2]) < 0 ) return false;
			else return recIsHeap(2*cursor + 2);
		}
		else return true;
	}
	
	public boolean isHeap(){
		return recIsHeap(0);
	}
	
	@SuppressWarnings("unchecked")
	public Object[] heapSort(T[] array)
	{
		Heap<T> temp = new Heap<T>(array);
		temp.makeItHeap();

		for(int i = temp.lastIndex; i >= 1; i--)
		{
			T t = (T) temp.heap[0];
			temp.heap[0] = temp.heap[i];
			temp.heap[i] = t;
			temp.lastIndex = i-1;
			temp.reheapDown(temp.heap[0], 0); 
		}
		return temp.heap;
	}
	
	@SuppressWarnings("unchecked")
	private void reheapUp(T item)
	{
		int hole = lastIndex;

		// hole is not the root and take advantage of short circuit
		while ((hole > 0) && ( ((Comparable<T>)item).compareTo(heap[(hole -1)/2]) > 0)){		//when the item value is still larger than parent value		
				heap[hole] = heap[(hole - 1) / 2]; // move hole's parent down
				hole = (hole - 1) / 2;          // move hole up
		}
		heap[hole] = item;                        // place item into final hole
	}

	public void enqueue(T item) {
		if (lastIndex == arrayCap - 1)
			throw new RuntimeException("Priority queue is full");									
		else {
			lastIndex = lastIndex + 1;  //create a hole
			reheapUp(item);
		}
	}
								
	private void reheapDown(T item, int hole) {
		// item was the last item before, now is moved up to the root
		// the job is find the proper position of the tree AND move that item into
		// note: it is for DEQUEUE method, the item is AREADY there
		
		// hole is INITAILLY the root node
		int newhole;      		 // index where hole should move to

		newhole = newHole(hole, item);   	// find next hole
		while (newhole != hole){
		    heap[hole] = heap[newhole];  	// move item up
		    hole = newhole;                 // move hole down
		    newhole = newHole(hole, item);  // find next hole
	    }
		heap[hole] = item;          		// fill in the final hole
	}
	
	@SuppressWarnings("unchecked")
	private int newHole(int hole, T item)
	{
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		
		// --> the job is to pick whether the left or the right will be moved up (exchanged) its parent (the moving down)

		if (left > lastIndex)  return hole; 			// hole has no children      
		else if (left == lastIndex)
		{					// hole has left child only
			
			if (((Comparable<T>)heap[left]).compareTo(item) > 0) return left;		
			else  return hole;		 	// item >= left child        
		}
		else if (((Comparable<T>)heap[left]).compareTo(heap[right]) < 0)
		{ // two children 							
				if (((Comparable<T>)heap[right]).compareTo(item) <= 0) return hole; 
				else   return right; 	// item < right child
		}	     	
		else if (((Comparable<T>)heap[left]).compareTo(item) <= 0) return hole; 				// left child >= right child & left child <= item      	
		else return left;   			// item < left child     
	}
	
	public T dequeue() // two jobs: 1. return the root node value 2. reconstruct the tree
	{		
		T toReturn;          // item to be dequeued and returned
		T toMove;    		  // item to move down heap

		if (lastIndex == -1)
		    throw new RuntimeException("Priority queue is empty");
		else 
		{
		     toReturn = heap[0];           		// remember item to be returned
		     toMove = heap[ lastIndex ]; 	 	// item to reheap down
		     lastIndex = lastIndex - 1;     	// decrease priority queue size		
		     reheapDown(toMove, 0);            	// restore heap properties
		     return toReturn ;                  // return largest element
	    }
	}

	public boolean isEmpty(){
		return lastIndex == -1;
	}
	
	public String toString(){
		String toReturn = "";
		for(int i = 0; i <= lastIndex; i++){
			toReturn += heap[i] + " ";
		}
		return toReturn;
	}
	
	private void recPrint(int cursor, int depth){
	    if(cursor <= lastIndex){
	      recPrint(2*cursor+2, depth+1);
		      for(int i = 1; i <= 4*depth; i++)
		        System.out.print(" ");
		      System.out.println(heap[cursor]);
	      recPrint(2*cursor+1, depth+1);
	    }
	}
	  
	public void print(){
	    recPrint(0, 0);
	}
}
