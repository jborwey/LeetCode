import java.util.ArrayList;
import java.util.List;

/**
 * Created by jb039k on 1/16/2017.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> s = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(i%5==0 && i%3==0){
                s.add("FizzBuzz");
            }
            else if(i%3 == 0){
                s.add("Fizz");
            }
            else if(i%5 == 0){
                s.add("Buzz");
            }
            else{
                s.add(String.valueOf(i));
            }
        }

        return s;
    }
}
