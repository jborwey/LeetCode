/**
 * Created by jb039k on 2/27/2017.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given non-empty integer array
 * Find minimum numbers of moves required to make all array elements equal
 * one move == incrementing or decrementing element by 1
 */
public class MinMovesEqualArrayElements {

    public static int minMoves2(int[] nums){
        Arrays.sort(nums);
        Map<Integer, Integer> numCount = new HashMap<>();
        int length = nums.length;
        int midValue = nums[(length/2)];
        int minMoves = 0;

        for(Integer i : nums){
            if(numCount.containsKey(i)){
                numCount.merge(i, 1, (oldValue, one) -> oldValue + one);
            }
            else{
                numCount.put(i, 1);
            }
        }
        /**
         * iterate through the map. If the value is less than or greater than the midValue add the difference
         * of the two to minMoves
         */
        for(Integer i : numCount.keySet()){
            if(i > midValue || i < midValue){
                minMoves = minMoves + Math.abs(i - midValue)*numCount.get(i);
            }
        }

        return minMoves;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        int minMoves = minMoves2(nums);
        System.out.println(minMoves);
    }
}
