import java.util.HashMap;
import java.util.Map;

/**
 * Created by jb039k on 2/28/2017.
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine){
        Map<Character, Integer> magazines = new HashMap<>();
        for(Character ch : magazine.toCharArray()){
            if(magazines.containsKey(ch)){
                magazines.merge(ch, 1, (oldValue, one) -> oldValue + one);
            }
            else{
                magazines.put(ch, 1);
            }
        }

        for(Character ch : ransomNote.toCharArray()){

            if(!magazines.containsKey(ch) || magazines.get(ch) <= 0){
                return false;
            }
            else{
                magazines.merge(ch, 1, (oldValue, one) -> oldValue - one);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
