package Sorting;

import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{	
	static final int SIZE = 50000; // size of array to be sorted
	
	
	static int[] values = new int[SIZE];	
	
	
	public static void main(String[] args)
	{
        testMergeSortNew();
        System.out.println();
		//initialize an unsorted array
		initValues(); 
		//printValues();
		//System.out.println("values is sorted: " + isSorted());
		//make new array with same value is array values[] for testing purpose
		int[] testvalues = new int[SIZE];	
		for (int i=0; i<SIZE; i++ )
		{
			testvalues[i] = values[i];
		}	
		
		// check normal insertion sort
		long startTime1, endTime1, startTime2, endTime2;
		startTime1 = System.currentTimeMillis();
		insertionSort();  
		endTime1 = System.currentTimeMillis();
		System.out.println("Performance by the normal insertion sort: " + (endTime1 - startTime1) + "ms");
	//	printValues();
		
		System.out.println();
		
		//recursiveBubbleSort();
		//bubbleCombinedSort();
		startTime2 = System.currentTimeMillis();
		binaryInsertionSort(testvalues);  
		endTime2 = System.currentTimeMillis();
		System.out.println("Performance by the binary insertion sort: " + (endTime2 - startTime2) + "ms");
	//	printValues();
		System.out.println("values is sorted: " + isSorted());		
	}
	
	static void initValues()
		// Initialize the values array with random integers from 0 to 99
		{
			Random rand = new Random();
			for (int index = 0; index < SIZE; index++)
			{
				values[index] = Math.abs(rand.nextInt()) % 100;
			}
		}
	
	static public boolean isSorted()
	// Return true if the array values are sorted, and false otherwise
	{
		boolean sorted = true;
		for (int index = 0; index < (SIZE - 1); index++)
		{
			if (values[index] > values[index+1])
				sorted = false;
		}
		return sorted;
	}
	
	static public void swap (int index1, int index2)
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}
	
	
	public static void printValues()
	{
		int value;
		DecimalFormat fmt = new DecimalFormat("00");
		System.out.println("The values array is: ");
		for (int index = 0; index < SIZE; index++)
		{
			value  = values[index];
			if ( ( (index + 1) % 10 ) == 0 )
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");				
		}
		System.out.println();
	}	
	
	/** Iterative Bubble Sort (Up, Down, Combined) **/
	static void bubbleUp(int startIndex, int endIndex)
	{
		for (int index = endIndex; index > startIndex; index--)
		{
			if (values[index] < values[index - 1])
			{
				swap(index, index -1);
			}
		}
	}
	
	static void bubbleDown(int endIndex, int startIndex)
	{
		//for (int index = endIndex; index > startIndex; index--)
		for (int index = startIndex; index <endIndex; index++)
		{
			if (values[index] > values[index + 1])
			{
				swap(index, index + 1);
			}
		}
	}

	
	static void bubbleUSort()
	{
		int current = 0;
		while (current < (SIZE -1))
		{
	    	bubbleUp(current, SIZE -1);			
			current++;			
		}		
	}
	
	static void bubbleDSort()
	{
		
		int current = SIZE - 1;
		while (current > 0)
		{
	    	bubbleDown(current, 0);			
			current--;			
		}		
	}
	
	static void bubbleCombinedSort()
	{
		
		int currentBottom = SIZE - 1;	
		int currentTop = 0;
		while (currentBottom > 0 && currentTop < (SIZE -1))
		{	
			bubbleUp(currentTop, currentBottom);			
	    	currentTop++;			
	    	bubbleDown(currentBottom, currentTop);			
	    	currentBottom--;	    	
		}			
	}
	
	/** Iterative Bubble Sort (Up, Down, Combined)  **/
	
	/** Recursive Bubble Sort **/
	static void recursiveBubbleSort()
	{
		rbSort(0);
	}
	
	static void rbSort(int startIndex)
	{
		if (startIndex == SIZE - 1)
			return;
		else
		{
			bubbleUp(startIndex, SIZE - 1);			
			rbSort(startIndex + 1);
		}
	}
	/** Recursive Bubble Sort **/
	
	/** Merge Sort **/
	static void mergeSort(int first, int last)
	{
		if (first < last)
		{
			int middle = (first + last)/2;
			mergeSort (first, middle);
			mergeSort (middle+1, last);
			merge(first, middle, middle + 1, last);			
		}
	}
	
	static void merge (int leftFirst, int leftLast, int rightFirst, int rightLast)
	{
		int[] tempArray = new int[SIZE];
		int index = leftFirst;
		int saveFirst = leftFirst;  // to remember where to copy back
		
		while ((leftFirst <= leftLast) && (rightFirst <= rightLast))
		{
			if (values[leftFirst] < values[rightFirst]){
				tempArray[index] = values[leftFirst];
				leftFirst++;
			}else{
				tempArray[index] = values[rightFirst];
				rightFirst++;				
			}
		}
		
		while (leftFirst <= leftLast)
		{
			tempArray[index] = values[leftFirst];
			leftFirst++;
			index++;
		}
		
		while (rightFirst <= rightLast)
		{
			tempArray[index] = values[rightFirst];
			rightFirst++;
			index++;
		}
		
		for (index = saveFirst; index <= rightLast; index++)
		{
			values[index] = tempArray[index];
		}		
	}	
	/** Merge Sort **/

    /** Merge Sort 2**/

    public static int[] mergeSortNew(int[] a){
        if (a.length == 1){
            return a;
        }else{ // if (a.length > 1)

            /** Divide a into two arrays **/
            // get the ceil and floor from the a.length. Purpose is to resolve problem with odd number of elements
            int ceil = (int)Math.ceil(a.length/2);
            int floor = (int)Math.floor(a.length/2);
            // initialize array a1 and a2; assign the size of each array
            int []a_1 = new int[ceil];
            int []a_2 = new int[floor];

            // put elements from a to a_1 and a_2
            for (int i1 = 0; i1 < ceil; i1++){
                a_1[i1] = a[i1];
            }

            for (int i2 = 0; i2 < floor; i2++){
                a_2[i2] = a[i2];
            }

            int[] a_1_new = mergeSortNew(a_1);
            int[] a_2_new = mergeSortNew(a_2);

            /** Conquer part starts here, eventually, we will gradually have sorted array returned from each stack call return**/

            // first, create a new array whose size equal to size of two small arrays
            int[] sorted_a = new int[a_1_new.length + a_2_new.length];

            int index1 = 0;
            int index2 = 0;
            int newIndex = 0;

            // if no elemental array is empty yet
            while (index1 < a_1_new.length && index2 < a_2_new.length){
            //for (newIndex=0; newIndex < sorted_a.length; newIndex++){
                if (a_1_new[index1] <= a_2_new[index2]){
                    sorted_a[newIndex] = a_1_new[index1];
                    index2++;
                    newIndex++;
                }else{
                    sorted_a[newIndex] = a_2_new[index2];
                    index1++;
                    index2++;
                }
            }

            // at this moment, either one of two lists is empty
            // if a_1 is not empty, the rest of sorted array is the rest of a_1
            if (index1 < a_1_new.length){
                for (int i = newIndex; i < sorted_a.length; i++){
                    sorted_a[i] = a_1_new[i];
                }
            }
            // if a_2 is not empty, the rest of sorted array is the rest of a_2
            if (index2 < a_2_new.length){
                for (int i = newIndex; i < sorted_a.length; i++){
                    sorted_a[i] = a_2_new[i];
                }
            }

            //now, in this level, the array is sorted, return it to the previous stack
            return sorted_a;
        }
    }

    public static void testMergeSortNew(){
        int[] a = {2,6,3,5,1};
        int[] sorted_a = mergeSortNew(a);
        System.out.println("First element: " + sorted_a[0] +" Last Element: " + sorted_a[4]);

    }
	
	/** Insertion Sort **/
	static void insertionSort()
	{
		for (int count = 1; count < SIZE; count++)
		{
			insertElement(0, count); // make the insertion
			/*
			if (values[count] > values[count-1])
				swap(count, count -1);
			else if (values[count] < values[0])
			{
				int temp = values[count];
				for (int i = 0; i <= count; i++)
				{
					values[i+1] = values[i];
				}
				values[0] = temp;
			}
			else 
			{	
				insertElement2(0, count);
				// now foundIndex is in its right place; do the for loop with swapping procedure
			} */
		}
	}
	
	static void insertElement (int startIndex, int endIndex)
	{
		boolean finished = false;
		int current = endIndex;
		boolean moreToSearch = true;
		
		 while (moreToSearch && !finished)
		 {
			 if ( values[current-1] > values[current] )
			 {
				 swap(current, current-1);
				 current--;
				 moreToSearch = (current!= startIndex);
			 }
			 else 
				 finished = true;
		 }
	}	
	
	public static void binaryInsertionSort(int[] unsortedArray)
	{
	     for (int i=0;i<SIZE;++i )
	     {	        
	         int leftIndex=0;
	         int rightIndex=i;
	          while (leftIndex < rightIndex)
	          {
	              int middle = (leftIndex+rightIndex)/2;
	              if (unsortedArray[i] >= unsortedArray[middle])
	            	  leftIndex = middle + 1;
	              else
	            	  rightIndex = middle;
	          }
	           for (int j=i;j > rightIndex;j--)
	           {
	        	   // swapping
	            	int temp = unsortedArray[j-1];
	            	unsortedArray[j-1] = unsortedArray[j];
	            	unsortedArray[j] = temp;
	           }
	    }
	}
	
	/** Insertion Sort **/
	
	
	
}

	















