import java.util.Arrays;

/**
 * Created by jb039k on 2/28/2017.
 */
public class AssignCookies {

    /**
     * Each child gets at most 1 cookie
     * Each child has a greed factor (g_i) which is the minimum size of cookie that the child will be content with
     * cookie j is size s_j
     * if s_j >= g_i - child i will be content
     * maximize number of content children and output the max number
     */

    public static int assignCookies(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int happyKids = 0;
        int kid = 0;

        for(int cookie=0; cookie<s.length; cookie++){
            if(kid == g.length){
                break;
            }
            else if(s[cookie] >= g[kid]){
                happyKids++;
                kid++;
            }
        }
        return happyKids;
    }


    public static void main(String[] args) {
        int[] children = {10, 9, 8 ,7};
        int[] cookies = {5, 6, 7 , 8};
        int maxContent = assignCookies(children, cookies);
        System.out.println(maxContent);
    }
}
