/**
 * Created by jb039k on 2/27/2017.
 */

/**
 * Given non-empty integer array
 * Find minimum numbers of moves required to make all array elements equal
 * one move == incrementing n-1 elements by 1
 */
public class MinMovesEqualArrayElements {

    public static int minMoves2(int[] nums){
        int result = 0;
        int minNum = nums[0];
        for(Integer i : nums){
            minNum = Math.min(minNum, i);
        }
        for(Integer n : nums){
            result += n - minNum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int minMoves = minMoves2(nums);
        System.out.println(minMoves);
    }
}
