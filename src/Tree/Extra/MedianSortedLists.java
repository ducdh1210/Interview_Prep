package Tree.Extra;


/**
 * Created by ducdh1210 on 10/13/14.
 */

import Tree.*;

import java.util.*;


public class MedianSortedLists {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose size of the array: ");
        int size = scanner.nextInt();

        Set[] a = getArrayOfSets(size);
        Set<Integer> set1 = a[0];
        Set<Integer> set2 = a[1];
        System.out.println(set1);
        System.out.println(set2);

        set1.addAll(set2);
        System.out.println(set1);
        Iterator<Integer> iterator = set1.iterator();

        int count = 0;
        while(iterator.hasNext()){
            if (count == size - 1){
                System.out.println(iterator.next());
                break;
            }
            iterator.next();
            count++;
        }
    }

    public static Set[] getArrayOfSets(int size){
        Set<Integer>[] arrayOfSets = new Set[2];
        Set<Integer> newSet = new TreeSet<Integer>();
        int numItem = 0;
        while (numItem < size){
            int randNum = (int)(Math.random()*100);
            if (!newSet.contains(randNum)){
                newSet.add(randNum);
                numItem++;
            }
        }
        arrayOfSets[0] = newSet;

        Set<Integer> newSet2 = new TreeSet<Integer>();
        numItem = 0;
        while (numItem < size){
            int randNum = (int)(Math.random()*100);
            if (!newSet.contains(randNum)){
                newSet2.add(randNum);
                numItem++;
            }
        }

        arrayOfSets[1] = newSet2;

        return arrayOfSets;

    }


}
