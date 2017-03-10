import java.util.Arrays;

/**
 * Created by jb039k on 3/10/2017.
 */

/**
 * array is size n
 * the majority element appears more than n/2 times
 */
public class MajorityElement {

    public static int majorityElement(int[] nums){
        int length = nums.length;
        if(length < 3){
            return nums[0];
        }

        Arrays.sort(nums);
        int frequency = 1;
        int current = nums[0];


        for(int i=1; i<length; i++){
            if(frequency > (length/2)){
                break;
            }
            else if(nums[i] != current){
                current = nums[i];
                frequency = 1;
            }
            else{
                frequency++;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 7, 7, 3, 5, 2, 1, 8, 9, 5, 7, 5};
//        int[] nums = {3, 2, 3};
        int majority = majorityElement(nums);
        System.out.println(majority);
    }
}
