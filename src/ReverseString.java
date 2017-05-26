/**
 * Created by jb039k on 1/16/2017.
 */
public class ReverseString {
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
}
