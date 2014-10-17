package CompanyQuestions;

/**
 * Created by ducdh1210 on 10/16/14.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class ColorfulNumber {

    public static void main(String[] args) {
        System.out.println(isColorful("236"));

        Set<Integer> newSet = new HashSet<Integer>();
        boolean a1 = newSet.add(10);
        System.out.println(a1);
        boolean a2 = newSet.add(9);
        System.out.println(a2);
        boolean a3 = newSet.add(8);
        System.out.println(a3);
        boolean a4 = newSet.add(10);
        System.out.println(a4);
        boolean a5 = newSet.add(7);
        System.out.println(a5);

    }

    static boolean isColorful(String number){

        int len=number.length();

        ArrayList<Integer> intarray = new ArrayList<Integer>();
        Integer val = null;
        if (number != null) {
            for (int i = 0; i < len; i++)
                intarray.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        if(intarray.size()==2 ||intarray.size()>10 || intarray.contains(0)|| intarray.contains(1))
            return false;

        Set<Integer> set = new HashSet<Integer>(intarray);
        System.out.printf("set.size(): %d \n",set.size());
        System.out.printf("intarray.size(): %d \n",intarray.size());
        //Check if the number contains duplicates
        if(set.size() < intarray.size())
            return false;
        else{

            for(int i=0; i < intarray.size() - 1; i++){
                System.out.println("intarray.size(): " + intarray.size());

                val = intarray.get(i) * intarray.get(i+1);
                System.out.printf("val: %d - ", val);
                boolean value = set.add(val);
                System.out.printf("boolean value: %b\n", value);
                if(!value){
                    return false;
                }
            }
        }
        return true;
    }



}
