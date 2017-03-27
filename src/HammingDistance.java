/**
 * Created by jb039k on 3/27/2017.
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y){

        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        int hamDist = hammingDistance(x, y);
        System.out.println(hamDist);
    }
}
