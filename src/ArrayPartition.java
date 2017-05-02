import java.util.Arrays;

/**
 * Created by jb039k on 5/2/2017.
 */
public class ArrayPartition {

    public static int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int maxSum = 0;
        int j = nums.length;

        if(j <= 2){
            return Math.min(nums[0], nums[1]);
        }

        for(int i=j-1; i>=0; i--){
            int sum = Math.min(nums[j-2], nums[i-1]);
            maxSum = sum + maxSum;
            j -= 2;


        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 5, 6, 7 , 2};
        int maxSum = arrayPairSum(nums);
        System.out.println(maxSum);
    }
}
