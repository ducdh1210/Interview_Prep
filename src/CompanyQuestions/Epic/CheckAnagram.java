package CompanyQuestions.Epic;

import java.util.HashMap;

/**
 * Created by ducdh1210 on 10/19/14.
 */
public class CheckAnagram {
    public static void main(String[] args) {
        boolean isAnagram = true;
        String s1 = "I love you";
        String s2 = "Love I bou";
        s1 = s1.toLowerCase(); s1 = s1.replaceAll("\\s+","");
        s2 = s2.toLowerCase(); s2 = s2.replaceAll("\\s+","");
        System.out.println(s1 + " " + s2);

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++){
            Character charObject = new Character(s1.charAt(i));
            Integer intObj = hm.get(charObject);
            if (intObj == null){
                hm.put(charObject, new Integer(0));
            }else{
                hm.put(charObject, intObj.intValue() + 1);
            }
        }

        for (int j = 0; j < s2.length(); j++){
            Character charObject = new Character(s2.charAt(j));
            Integer intObject = hm.get(charObject);
            if (intObject == null || intObject.intValue() < 0){
                isAnagram = false;
            }else{
                hm.put(charObject, intObject.intValue() - 1);
            }
        }

        System.out.println(isAnagram);



    }
}
