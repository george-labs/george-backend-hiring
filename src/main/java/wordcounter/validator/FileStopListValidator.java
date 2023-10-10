package wordcounter.validator;

import wordcounter.StopListValidator;

public class FileStopListValidator implements StopListValidator {
    @Override
    public boolean isOnStopList(String stopWords, String targetWord) {
        for (String word: stopWords.split(" ")){
            if (word.equals(targetWord)) return true;
        }
        return false;
    }
}
