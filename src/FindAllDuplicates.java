import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jb039k on 2/13/2017.
 */
public class FindAllDuplicates {

    public static List<Integer> findDuplicates(int[] nums){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int n : nums){
            if(set.contains(n)){
                list.add(n);
            }
            else{
                set.add(n);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDuplicates(nums);
        System.out.println(list);
    }
}
