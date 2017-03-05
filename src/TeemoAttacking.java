
/**
 * Created by JTB on 3/4/2017.
 */
public class TeemoAttacking {

    public static int findPoisondedDuration(int[] timeSeries, int duration){
        int length = timeSeries.length;
        if(length == 0){
            return 0;
        }

        int DoT = 0;
        int expiration = timeSeries[0] + duration;

        for(int i=1; i<length; i++){
            int currentAttack = timeSeries[i];
            if(currentAttack >= expiration){
                DoT = DoT + duration;
                expiration = currentAttack + duration;
            }
            else{
                DoT = DoT + (currentAttack - timeSeries[i-1]);
                expiration = currentAttack + duration;
            }

        }
        return DoT + duration;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        int damageOverTime = 2;
        int damage = findPoisondedDuration(timeSeries, damageOverTime);
        System.out.println(damage);
    }
}
