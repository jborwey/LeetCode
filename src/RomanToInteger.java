import java.util.HashMap;
import java.util.Map;

/**
 * Created by jb039k on 3/20/2017.
 */
public class RomanToInteger {
    public static int romanToInt(String s){
        char[] numeralCharArray = s.toCharArray();
        Map<Character, Integer> numeralMap = new HashMap<>();
        numeralMap.put('I', 1);
        numeralMap.put('V', 5);
        numeralMap.put('X', 10);
        numeralMap.put('L', 50);
        numeralMap.put('C', 100);
        numeralMap.put('D', 500);
        numeralMap.put('M', 1000);

        int lastNumeral = numeralMap.get(numeralCharArray[0]);
        int result = lastNumeral;

        for(int i=1; i<numeralCharArray.length; i++){
            int currentNumeral = numeralMap.get(numeralCharArray[i]);

            if(currentNumeral > lastNumeral){
                result = result - lastNumeral;
                result = result + (currentNumeral-lastNumeral);
                continue;
            }
            result = result + currentNumeral;
            lastNumeral = currentNumeral;
        }

        return result;
    }

    public static void main(String[] args) {
        String numeral = "IV";
        int value = romanToInt(numeral);
        System.out.println(value);
    }
}
