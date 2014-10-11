package JavaCollection;

/**
 * Created by ducdh1210 on 10/11/14.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;


public class HashMapExample {
    public static void main(String[] args){

        //testHashMap();
        testSortedHashMap();
    }

    public static void testHashMap(){
        HashMap<Integer, String> map = new HashMap<Integer, String> ();
        map.put(5,"Five");
        map.put(8,"Eight");
        map.put(8, "Duplicated Eight"); /* you can have duplicate value, but if you have duplicate keys, only the last one is effective*/
        map.put(6,"Six");
        map.put(4,"Four");
        map.put(2,"Two");

        String text = map.get(8); System.out.printf("Value for key 8 is: %s\n\n", text);

        /* strange mechanism to iterate through pair in map*/

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value);
        }
        /* Note that: HashMap object is not sorted at all, so that the next time we
        * iterate, the order of each pair can be totally different */
    }

    public static void testSortedHashMap(){
        Map<Integer, String> map = new HashMap<Integer, String> ();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        Map<Integer, String> treeMap = new TreeMap<Integer, String>();

        System.out.println("Hash Map Iteration"); // maintain the natural order of key
        testSortedHashMap(map);
        System.out.println("\nLinked Hash Map Iteration"); // maintain the order you put the key-value pair in
        testSortedHashMap(linkedHashMap);
        System.out.println("\nTree Hash Map Iteration"); // sort the key into natural order
        testSortedHashMap(treeMap);
        System.out.println();
    }

    public static void testSortedHashMap(Map<Integer, String> map){
        map.put(9, "fox");
        map.put(4, "cat");
        map.put(8, "dog");
        map.put(1, "giraffe");
        map.put(0, "swan");
        map.put(15, "bear");
        map.put(6, "snake");

        for (Integer key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
