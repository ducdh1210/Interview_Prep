package ArrayAndString;

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

}
