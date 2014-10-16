package Sorting;

import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{	
	static final int SIZE = 50000; // size of array to be sorted

	static int[] values = new int[SIZE];

	public static void main(String[] args)
	{
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
	/** End Merge Sort **/

	/** Insertion Sort **/
	static void insertionSort()
	{
		for (int count = 1; count < SIZE; count++)
		{
			insertElement(0, count); // make the insertion
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
	
	/** End Insertion Sort **/


	
}

	















