package ArrayAndString;

public class ArrayStringProb {
	/*Implement an algorithm to determine if a string has all unique characters.
    What if you can not use additional data structures */
    public static boolean isUniqueChars2(String str){
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++){
            int val = str.charAt(i);            
            if (char_set[val]){
                System.out.println("false");
                return false;
            }
            System.out.println("true");
            char_set[val] = true;
        }
        return true;
    }
    /*Write code to reverse a C-Style String.
    (C-String means that “abcd” is represented as five characters, including the null character.)*/
    public static void reverse(String word) {
        char[] chs = word.toCharArray();

        int i=0, j=chs.length-1;
        while (i < j) {
            // swap chs[i] and chs[j]
            char t = chs[i];
            chs[i] = chs[j];
            chs[j] = t;
            i++; j--;
        }
        String newString = String.valueOf(chs);
        System.out.print(newString);
    }
    /*remove duplicates from substring*/
    public static void removeDuplicates(String s)
    {
        char [] temp = s.toCharArray();
        int length =temp.length;
        System.out.println(length);
        for (int i=0;i<length;i++){
            System.out.println("i = " + i);
            System.out.println("current string with i: " + s.substring(i));
            for (int j = i+1; j<length;j++){
                System.out.println("    j = " + j);

                if(temp[i]==temp[j]){
                    System.out.println("        temp[i]==temp[j]");
                    int test =j;
                    for(int k=j+1; k<length ; k++){
                        System.out.println("            k = " + k);
                        temp[test] = temp[k];
                        test++;
                    }
                    length--;
                    //j--;
                    System.out.println("        length = " + length);
                    System.out.println("        j = " + j);
                    System.out.println("        temp: " + String.copyValueOf(temp).substring(0,length));

                }
            }
        }
        System.out.println("\nEnd result: " + String.copyValueOf(temp).substring(0,length));
    }

    /*String with non-contiguous duplicate*/
    public static void removeDuplicatesEff(char[] str){
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;
        boolean[] hit = new boolean[256];
        for (int i = 0; i < 256; ++i){
            hit[i] =false;
        }
        hit[str[0]]=true;
        int tail = 1;
        for (int i = 1; i < len; i++){
            if (!hit[str[i]]){
                str[tail] = str[i];
                ++tail;
                hit[str[i]] = true;
            }
        }
        str[tail] = 0;
        System.out.print(String.valueOf(str));
    }

}
