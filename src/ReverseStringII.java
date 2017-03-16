/**
 * Created by jb039k on 3/16/2017.
 */
public class ReverseStringII {
    public static String reverseStr(String s, int k){
        int length = s.length(), subLength = 2*k, remaining = length;
        String result = "";
        String substring;

        for(int i=0; i<length; i++){
            StringBuilder sb = new StringBuilder();
            if(remaining > subLength){
                String firstHalf = s.substring(i, i+k);
                String secondHalf = s.substring(i+k, i+subLength);
                sb.append(firstHalf).reverse();
                substring = sb.toString() + secondHalf;
                result = result.concat(substring);
                remaining = remaining - subLength;
                i = i + subLength - 1;
            }
            else if(remaining < k){
                substring = s.substring(i, length);
                sb.append(substring).reverse();
                result = result.concat(sb.toString());
                break;
            }
            else{
                String firstHalf = s.substring(i, i+k);
                String secondHalf = s.substring(i+k, length);
                sb.append(firstHalf).reverse();
                substring = sb.toString() + secondHalf;
                result = result.concat(substring);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "abcdefg";
        int k = 2;
        String result = reverseStr(input, k);
        System.out.println(result);
    }
}
