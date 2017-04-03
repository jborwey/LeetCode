/**
 * Created by jb039k on 3/31/2017.
 */
public class ArithmeticSlices {

    public static int numberOfArithmeticSlices(int[] A){
        int length = A.length;
        if(length < 3){
            return 0;
        }

        int numSlices = 0;
        int current = 0;
        for(int i=2; i<length; i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                current += 1;
                numSlices += current;
            }
            else{
                current = 0;
            }
        }

        return numSlices;
    }

    public static void main(String[] args) {
        int[] slice = {1,2,3,4};
        int numSlices = numberOfArithmeticSlices(slice);
        System.out.println(numSlices);

    }
}
