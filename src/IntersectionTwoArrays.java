import java.util.HashSet;
import java.util.Set;

/**
 * Created by jb039k on 3/2/2017.
 */
public class IntersectionTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> setNums1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();


        for(Integer i : nums1){
            setNums1.add(i);
        }
        for(Integer j : nums2){
            if(setNums1.contains(j)){
                intersect.add(j);
            }
        }
        int[] result = new int[intersect.size()];
        int i=0;

        for(Integer num : intersect){
            result[i++] = num;
        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = intersection(nums1, nums2);
        for(int i : intersect){
            System.out.printf("%d" + " ", i);
        }
    }
}
