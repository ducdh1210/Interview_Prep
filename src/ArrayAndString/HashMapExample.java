package ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class HashMapExample {
	 public static void test(){
	        HashMap<Integer, String> map = new HashMap<Integer,String>();
	        map.put(21,"Twenty one");
	        map.put(31, "Thirty One");
	        Iterator<Integer> keySetIterator  = map.keySet().iterator();

         while(keySetIterator.hasNext()){
	            Integer thisKey = keySetIterator.next();
	            System.out.println("Key: " + thisKey + " value: " + map.get(thisKey));
	        }
	 }

    public static void main(String[] args) {


        String s1 = "I love you";
        // convert String to char array
        char[] charArray = s1.toCharArray();
        System.out.println(charArray.length);

        // sort an integer array
        int [] intArray = {1,2,4,5,-1,-3,9,8};
        Arrays.sort(intArray);
        System.out.println(intArray[0]);

        // string to integer
        Integer intObj = Integer.valueOf("40");
        System.out.println(intObj);

        // integer to string
        String testString = String.valueOf(4);
        System.out.println(testString);
    }

}
