/**
 * Created by jb039k on 4/10/2017.
 */
public class ReverseWordsInStringIII {

    public static String reverseWords(String s){
        int length = s.length();
        char[] sArray = s.toCharArray();
        int i=0;

        for(int j=0; j<length; j++){
            if(sArray[j] == ' '){
                reverse(sArray, i, j-1);
                i = j+1;
            }
        }

        reverse(sArray, i, length-1);
        return new String(sArray);
    }

    public static void reverse(char[] sArray, int i, int j){
        while(i < j){
            char temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String result = reverseWords(s);
        System.out.println(result);
    }
}
