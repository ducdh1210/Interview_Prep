package Sorting;

public class Insertion {
	
	public static void main(String [ ] args){
		int[] array = {8,2,4,3,9,6};
		
		for (int j = 1; j < array.length; j++ ){
			int key = array[j];
			
			int i = j - 1;
			
			while (i >= 0 && array[i] > key){
				array[i+1] = array[i];
				i = i - 1;
			}
			
			array[i+1] = key;
		}
		
		for (int index = 0; index < array.length; index++){
			System.out.print(array[index]);
		}
	}

}
