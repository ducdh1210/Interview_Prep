/**
 * Created by ducdh1210 on 10/11/14.
 */

package JavaCollection;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListExample {
    public static void main(String[] args){
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();

        /* Basic indicator whether to use array list or linked list
        * want to add, remove item in the end of the list --> use array list
        * want to add, remove item anywhere else in the list --> use linked list
        * */

        doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);
    }

    private static void doTimings(String type, List<Integer> list){
        for (int i=0; i<1E5; i++ ){
            list.add(i);
        }

        long start = System.currentTimeMillis();

/*
        // Add item at the end of the list
        for (int i = 0; i < 1E5; i++ ){
            list.add(i);
        }
*/

        // Add item somewhere else in list
        for (int i = 0; i < 1E5; i++ ){
            list.add(0,i);
        }


        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end-start) + " ms for type " + type);
    }




}
