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
        int length = nums.length;
        int sum = 0;
        int minNum = Integer.MAX_VALUE;
        for(Integer i : nums){
            sum = sum + i;
            if(i<minNum){
                minNum = i;
            }
        }

        return sum - minNum * length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int minMoves = minMoves2(nums);
        System.out.println(minMoves);
    }
}
