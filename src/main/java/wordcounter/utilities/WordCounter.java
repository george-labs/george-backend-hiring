package wordcounter.utilities;

import wordcounter.constants.Constants;

import java.util.Set;

public class WordCounter {

    public static int countWords(String inputLine) {

        int answer = 0;
        if(null == inputLine){
            return 0;
        }
        String[] splittedInput = inputLine.split(Constants.SPACE_CHARACTER);
        Set<String> stopWords = FileReadingUtility.readStopwords();
        for(String possibleWord : splittedInput){
            if(stopWords.contains(possibleWord)){
                continue;
            }
            boolean isValidWord = isValidWord(possibleWord);
            if(isValidWord){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isValidWord(String possibleWord){
        return possibleWord.matches(Constants.VALID_WORD_REGEX);
    }

}
