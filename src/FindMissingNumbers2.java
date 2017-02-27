import java.util.ArrayList;
import java.util.List;

/**
 * Created by jb039k on 2/27/2017.
 */

/**
 * Second iteration
 * Given array of integers where 1 <= a[i] <= n ; n == size of array
 * Some elements appear twice and others appear once
 * Find all elements of [1, n] inclusive that do not appear in this array
 */

/**
 * Solution done in O(n) runtime without extra space
 * Return list does not count as extra space.
 */
public class FindMissingNumbers2 {

    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int num = Math.abs(nums[i]) - 1;
            if(nums[num] > 0){
                nums[num] = -nums[num];
                System.out.println();
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
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
