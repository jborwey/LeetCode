import java.util.HashSet;
import java.util.Set;

/**
 * Created by jb039k on 1/23/2017.
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Set<Integer> set = new HashSet<>();

        for(int element : nums){
            if(set.contains(element)){
                set.remove(element);
            }
            else{
                set.add(element);
            }
        }
        return (int)set.toArray()[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int single = singleNumber(nums);
        System.out.println(single);
    }
}
