import java.util.ArrayList;
import java.util.List;

/**
 * Created by jb039k on 2/22/2017.
 */
public class FindMissingNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>(nums.length);

        for(int i=0; i<nums.length; i++){
            int num = Math.abs(nums[i]) - 1;
            if(nums[num] > 0){
                nums[num] = -nums[num];
            }
        }

        for(int j=0; j<nums.length; j++){
            int num = nums[j];
            if(num > 0){
                result.add(j+1);
            }
        }
    return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result);
    }
}
