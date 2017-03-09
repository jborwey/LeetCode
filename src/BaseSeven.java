/**
 * Created by jb039k on 3/9/2017.
 */
public class BaseSeven {

    public static String convertToBase7(int num){
        if(num == 0){
            return "0";
        }

        StringBuilder numBase7 = new StringBuilder();
        boolean negative = false;

        if(num < 0){
            negative = true;
        }

        while(num != 0){
            numBase7.append(Math.abs(num%7));
            num = num/7;
        }

        if(negative){
            numBase7.append("-");
        }

        return numBase7.reverse().toString();
    }

    public static void main(String[] args) {
        int input = -7;
        String converted = convertToBase7(input);
        System.out.println(converted);
    }
}
