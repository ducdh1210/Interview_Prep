package CompanyQuestions.Epic;

import java.util.ArrayList;

/**
 * Created by ducdh1210 on 10/19/14.
 */
public class Seed {

    public static void main(String[] args) {
        seed(1716);
    }

    private static void seed(int i) {
        ArrayList<Integer> factor = new ArrayList<Integer>();
        for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0)
                factor.add(j);
        }
        System.out.println(factor);
        int temp = 1;
        for (int number : factor) {
            int temp2 = number; // placeholder for number
            temp = number;
            while ( number > 0 ){
                temp *= number % 10;
                number = number / 10;
            }
            if (temp == i)
                System.out.println(temp2);
        }
        System.out.println("done");
    }
}
