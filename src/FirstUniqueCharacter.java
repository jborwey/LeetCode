/**
 * Created by jb039k on 2/28/2017.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string find the first non-repeating character and return index
 * if it doesn't exist return -1
 */
public class FirstUniqueCharacter {

    public static int firstUniqueChar(String s){
        char[] charArray = s.toCharArray();
        Map<Character, Integer> stringMap = new HashMap<>();
        for(Character character : charArray){
            if(stringMap.containsKey(character)){
                stringMap.merge(character, 1, (oldValue, one) -> oldValue + 1);
            }
            else{
                stringMap.put(character, 1);
            }
        }

        for(int i=0; i<charArray.length; i++){
            if(stringMap.get(charArray[i]) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(firstUniqueChar(str));
    }
}
