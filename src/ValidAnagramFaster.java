/**
 * Created by jb039k on 3/27/2017.
 */

/**
 * Use array counting "buckets" to efficiently count the strings and decrement
 */
public class ValidAnagramFaster {

    public static boolean isAnagram(String s, String t){
        int[] countArray = new int[26];
        for(int i = 0; i<s.length(); i++){
            countArray[s.charAt(i) - 'a']++;
            System.out.println("yo");
        }
        for(int i = 0; i<t.length(); i++){
            countArray[t.charAt(i) - 'a']--;
        }
        for(int i : countArray){
            if(i != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "namagra";
        boolean isIt = isAnagram(s, t);
        System.out.println(isIt);
    }
}
