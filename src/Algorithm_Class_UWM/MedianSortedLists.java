package Algorithm_Class_UWM;


/**
 * Created by ducdh1210 on 10/13/14.
 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class MedianSortedLists {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose size of the array: ");
        int size = scanner.nextInt();

        Set[] a = getArrayOfSets(size);
        Set<Integer> set1 = a[0];
        Set<Integer> set2 = a[1];
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        set1.addAll(set2);
        System.out.println("Combined set: " + set1);
        Iterator<Integer> iterator = set1.iterator();

        System.out.print("Median of combined set: ");

        int count = 0;
        while(iterator.hasNext()){
            if (count == size - 1){
                System.out.println(iterator.next());
                break;
            }
            iterator.next();
            count++;
        }

        System.out.print("\nPlease choose kth in kth smallest element: ");
        int k = scanner.nextInt();
        count = 0;
        iterator = set1.iterator();
        while(iterator.hasNext()){
            if (count == k - 1){
                System.out.println("kth smallest element is: " + iterator.next());
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
