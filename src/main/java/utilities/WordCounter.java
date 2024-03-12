package utilities;

import static utilities.Constants.SPACE_CHARACTER;
import static utilities.Constants.VALID_WORD_REGEX;

public class WordCounter {

    public static int countWords(String inputLine) {

        int answer = 0;
        if(null == inputLine){
            return 0;
        }
        String[] splittedInput = inputLine.split(SPACE_CHARACTER);
        for(String possibleWord : splittedInput){
            boolean isValidWord = isValidWord(possibleWord);
            if(isValidWord){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isValidWord(String possibleWord){
        return possibleWord.matches(VALID_WORD_REGEX);
    }

}
