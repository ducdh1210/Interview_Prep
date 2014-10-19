package CompanyQuestions.Epic;

/**
 * Created by ducdh1210 on 10/19/14.
 */
public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("1"));
    }
    public static boolean isPalindrome(String s1){
        boolean isPalindrome = false;
        int length = s1.length();

        int lastIndexFromRight, lastIndexFromLeft;
        lastIndexFromLeft = lastIndexFromRight = 0;
        if (length == 0){
            return false;
        }
        if (length == 1){
            return true;
        }
        if (length % 2 == 0){
            lastIndexFromLeft = ((int)length/2) - 1;
            lastIndexFromRight = (int)length/2;
        }else{
            lastIndexFromLeft = ((int)length/2) - 1;
            lastIndexFromRight = (int)length/2 + 1;
        }
        System.out.println("lastIndexFromLeft: " + lastIndexFromLeft + " -- lastIndexFromRight: " + lastIndexFromRight);
        int leftIndex = 0;
        int rightIndex = length - 1;
        while (leftIndex <= lastIndexFromLeft){
            System.out.println("s1.charAt(leftIndex): " + s1.charAt(leftIndex) + " -- s1.charAt(rightIndex): " + s1.charAt(rightIndex));

            if (rightIndex >= lastIndexFromRight){
                if (s1.charAt(leftIndex) != s1.charAt(rightIndex)){
                    isPalindrome = false;
                    return isPalindrome;
                }else{
                    leftIndex++;
                    rightIndex--;
                }
            }
        }
        isPalindrome = true;

        return isPalindrome;
    }
}
