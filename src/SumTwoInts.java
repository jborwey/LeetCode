import java.util.stream.IntStream;

/**
 * Created by jb039k on 1/24/2017.
 */
public class SumTwoInts {

    public static int getSum(int a, int b) {
        IntStream i = IntStream.of(a, b);
        return i.sum();
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int sum = getSum(a, b);
        System.out.println(sum);
    }
}
