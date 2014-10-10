package Recursion;

/**
 * Created by ducdh1210 on 10/8/14.
 */
public class RecursionTest {

    public static void main(String[] args){
        System.out.print(fact(4));
    }

    /**
     * Classic factorial problem
     * */
    public static int fact(int n){
        if (n == 1) return 1;
        int subSolution = fact(n-1);
        int solution = subSolution * n;
        return solution;
        //else return n * fact(n-1);
    }



 }
