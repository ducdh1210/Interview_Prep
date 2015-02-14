package ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ducdh1210 on 1/15/15.
 */
public class CharacterFrequencyString {

    public static void main(String[] args) {

        String s = "jhjjnjhjjhugajh";
        HashMap<Character, Integer> hashmap = buildFrenquencyHashMap(s);

        for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
            Character characterObj = entry.getKey();
            Integer integerObj = entry.getValue();
            System.out.println(characterObj + " " + integerObj);
        }

        String s1 = "jjnjhjjhugajhjh";

        for (int i = 0; i < s1.length(); i++){
            char character = s1.charAt(i);
            Character charObj = new Character(character);
            Integer intObj = hashmap.get(charObj);
            if (hashmap.get(charObj) == null){
                System.out.println("N");
                break;
            }else{
                Integer currentCount = intObj - 1;
                hashmap.put(character, new Integer(currentCount));
                if (currentCount < 0){
                    System.out.println("N");
                    break;
                }
            }
        }


    }


    public static HashMap<Character, Integer> buildFrenquencyHashMap(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            Character charObj = new Character(character);
            Integer intObj = hm.get(charObj);

            if (intObj != null) {
                hm.put(charObj, new Integer(intObj + 1));
            } else {
                hm.put(charObj, new Integer(1));
            }
        }

        return hm;
    }
}
