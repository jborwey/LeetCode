import java.util.ArrayList;
import java.util.List;

/**
 * Created by JTB on 2/17/2017.
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        int[] countArray = new int[128];
        StringBuilder stringBuilder = new StringBuilder(s.length());
        for(char ch : s.toCharArray()){
            countArray[ch]++;
        }
        List<CharacterAndFrequency> characterAndFrequencyList = new ArrayList<>();

        for(char i=0; i<countArray.length; i++){
            int frequency = countArray[i];
            if(frequency > 0){
                CharacterAndFrequency characterAndFrequency = new CharacterAndFrequency(i, frequency);
                characterAndFrequencyList.add(characterAndFrequency);
            }
        }

        characterAndFrequencyList.sort((o1, o2) -> Integer.compare(o2.getFrequency(), o1.getFrequency()));
        for(CharacterAndFrequency characterAndFrequency : characterAndFrequencyList){
            for(int i=0; i<characterAndFrequency.getFrequency(); i++){
                stringBuilder.append(characterAndFrequency.getCharacter());
            }
        }

        return stringBuilder.toString();
    }

    public static class CharacterAndFrequency{
        private final char character;
        private final int frequency;

        public CharacterAndFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        public char getCharacter() {
            return character;
        }

        public int getFrequency() {
            return frequency;
        }
    }

    public static void main(String[] args) {
        String s = "tree";
        String sorted = frequencySort(s);
        System.out.println(sorted);
    }
}
