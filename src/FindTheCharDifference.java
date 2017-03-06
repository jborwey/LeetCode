/**
 * Created by jb039k on 2/13/2017.
 */
public class FindTheCharDifference {
    public static char findTheDifference(String s, String t){
        int sVal = 0;
        int tVal = 0;

        for(char c : s.toCharArray()){
            sVal = sVal + (int)c;
        }
        for(char k : t.toCharArray()){
            tVal = tVal + (int)k;
        }

        return (char)(tVal - sVal);
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        char ch = findTheDifference(s, t);
        System.out.println(ch);
    }
}
