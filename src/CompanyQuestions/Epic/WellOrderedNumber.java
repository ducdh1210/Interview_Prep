package CompanyQuestions.Epic;

/**
 * Created by ducdh1210 on 10/19/14.
 */
public class WellOrderedNumber {

    public static void main(String[] args) {
        printWellOrdered(0,0,4);
    }

    private static void printWellOrdered(int number, int prev, int n) {

        if(n==0){
            System.out.println(number);
            return;
        }

        for(int i=(prev+1); i<(11-n); i++){
            printWellOrdered(number*10 + i, i, n-1) ;
        }

    }
}
