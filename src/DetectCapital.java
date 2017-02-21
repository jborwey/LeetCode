package src;

/**
 * Created by jb039k on 2/21/2017.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word){
        int wordLength = word.length();
        int lowerCount = 0;

        for(int i=0; i<wordLength; i++){
            char letter = word.charAt(i);
            if(Character.isLowerCase(letter)){
                lowerCount++;
            }
        }
        // all letters are capital or all lower
        if(lowerCount == wordLength || lowerCount == 0){
            return true;
        }
        // only first capital
        if(lowerCount == wordLength-1){
            return Character.isUpperCase(word.charAt(0));
        }
        return false;
    }
}
