import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by JTB on 2/10/2017.
 */
public class NextGreaterElement2 {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int num : nums){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i=0; i<findNums.length; i++){
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }

        return findNums;
    }

    public static void main(String[] args) {
        int[] findNums = {2, 4};
        int[] nums = {1, 2, 3, 4};
        int[] found = nextGreaterElement(findNums, nums);

        for(int i : found){
            System.out.printf("%d" + " ", i);
        }
    }
}
