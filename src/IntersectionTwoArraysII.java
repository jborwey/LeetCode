import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jb039k on 3/29/2017.
 */
public class IntersectionTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2){
        int minLength = Math.min(nums1.length, nums2.length);
        int[] result = new int[minLength];
        Map<Integer, Integer> count = new HashMap<>();

        for(int i : nums1){
            if(count.containsKey(i)){
                count.merge(i, 1, (oldValue, one) -> oldValue + 1);
            }
            else{
                count.put(i, 1);
            }
        }

        int place = 0;

        for(int i : nums2){
            if(count.containsKey(i)){
                if(count.get(i) > 0){
                    count.merge(i, 1, (oldValue, one) -> oldValue - 1);
                    result[place] = i;
                    place++;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, place);
    }
    public static void main(String[] args) {
//        int[] nums1 = {-2147483648,1,2,3};
//        int[] nums2 = {1,-2147483648,-2147483648};
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};
//        int[] nums1 = {1, 2};
//        int[] nums2 = {1, 1};
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {5,0,0,6,1,6,2,2,4};
        int[] intersection = intersect(nums1, nums2);

        for(int i : intersection){
            System.out.printf("%d" + " ", i);
        }
    }
}
