/**
 * Created by ducdh1210 on 10/11/14.
 */

package JavaCollection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args){

        Set<String> genericHashSet = new HashSet<String>(); // HashSet does not retain order
        Set<String> linkedHashSet = new LinkedHashSet<String>(); // Remember the order you put item in
        Set<String> treeHashSet = new TreeSet<String>(); // Sort in natural order

        addItem(genericHashSet);
        addItem(linkedHashSet);
        addItem(treeHashSet);

        /* iteration */
        printIteration(genericHashSet); System.out.println();
        printIteration(linkedHashSet); System.out.println();
        printIteration(treeHashSet); System.out.println();

        /* does contain certain element? */
        System.out.println(linkedHashSet.contains("dog"));

        /* check if a set is empty */
        System.out.println(linkedHashSet.isEmpty());

        /* check size of the set */
        System.out.println(linkedHashSet.size());

        Set<String> hashSet2 = new HashSet<String>(); // Remember the order you put item in
        hashSet2.add("dog");
        hashSet2.add("cat");
        hashSet2.add("giraffe");
        hashSet2.add("ant");

        /* intersection */

        // Note: intersection is a new Set object which has the same element as genericHashSet.
        // Use System.identityHashCode(Object) to get address of the object
        Set<String> intersection = new HashSet<String>(genericHashSet);
        intersection.retainAll(hashSet2); // directly change the content of object intersection
        System.out.println(intersection);

        /* difference */
        Set<String> difference = new HashSet<String>(genericHashSet);
        difference.removeAll(hashSet2);
        System.out.println(difference);

    }

    public static void addItem(Set<String> givenSet){
        givenSet.add("dog");
        givenSet.add("cat");
        givenSet.add("mouse");
        givenSet.add("snake");
        givenSet.add("bear");
        // adding duplicate items
        givenSet.add("mouse");
        //System.out.println(givenSet);
    }

    public static void printIteration(Set<String> givenSet){
        for (String element : givenSet){
            System.out.print(element + " ");
        }
    }




}
