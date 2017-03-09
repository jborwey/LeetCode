import java.util.*;

/**
 * Created by jb039k on 2/9/2017.
 */
public class KeyboardRow {
    public static String[] findWords(String[] words) {
        Set<String> row1 = new HashSet<>(Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"));
        Set<String> row2 = new HashSet<>(Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l"));
        Set<String> row3 = new HashSet<>(Arrays.asList("z", "x", "c", "v", "b", "n", "m"));
        List<String> singleRowWords = new ArrayList<>();

        for(String word : words){
            Set<Integer> rowsUsed = new HashSet<>();
            int wordLength = word.length();
            for(int i=0; i<=wordLength; i++){
                if(rowsUsed.size() > 1){
                    break;
                }

                if(i==wordLength){
                    singleRowWords.add(word);
                    break;
                }

                Character ch = word.charAt(i);
                String s = ch.toString();



                if(row1.contains(s.toLowerCase()) || row1.contains(s.toUpperCase())){
                    rowsUsed.add(1);
                }
                else if(row2.contains(s.toLowerCase()) || row2.contains(s.toUpperCase())){
                    rowsUsed.add(2);
                }
                else{
                    rowsUsed.add(3);
                }
            }
        }
        String[] singles = new String[singleRowWords.size()];
        for(int i=0; i<singles.length; i++){
            singles[i] = singleRowWords.get(i);
        }
        return singles;
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        List<String> singles = new ArrayList<>(Arrays.asList(findWords(words)));
        System.out.println(singles);
    }
}
