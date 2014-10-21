package CompanyQuestions.Epic;

/**
 * Created by ducdh1210 on 10/19/14.
 */
public class PrintContinousLetters {

    public static void printContiAlpha(String in){
        in = in.toLowerCase();
        char prevChar = 'a';
        char currentChar = 'a';
        int i = 1;
        boolean contiguous = false;
        while(i<in.length()){
            prevChar = in.charAt(i-1);
            currentChar = in.charAt(i);
            if(currentChar==prevChar+1){
                System.out.print(prevChar);
                contiguous = true;
            }
            else{
                if(contiguous){
                    System.out.print(prevChar);
                    System.out.print("; ");
                }
                contiguous=false;
            }
            i++;
        }
        if(currentChar==prevChar+1) System.out.print(currentChar);
    }
    public static void main(String[] args) {
        String in = "AbcDefljdflsjflmnopflsjflasjftuvWxYz";
        //printContiAlpha(in);

    }
}
