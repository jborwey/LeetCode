import java.util.HashSet;
import java.util.Set;

/**
 * Created by jb039k on 3/20/2017.
 */
public class ContiansDuplicates {

    public static boolean containsDuplicates(int[] nums){
        Set<Integer> foundNums = new HashSet<>();
        for(int i : nums){
            if(foundNums.contains(i)){
                return true;
            }
            else{
                foundNums.add(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 2, 4, 9, 6, 3, 5};
        boolean hasDuplicates = containsDuplicates(nums);
        System.out.println(hasDuplicates);
    }
}
