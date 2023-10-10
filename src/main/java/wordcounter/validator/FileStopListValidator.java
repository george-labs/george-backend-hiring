package wordcounter.validator;

import wordcounter.StopListValidator;

public class FileStopListValidator implements StopListValidator {
    private final static String WORD_SEPARATOR = " ";
    @Override
    public boolean isOnStopList(String stopWords, String targetWord) {
        for (String word: stopWords.split(WORD_SEPARATOR)){
            if (word.equals(targetWord)) return true;
        }
        return false;
    }
}
