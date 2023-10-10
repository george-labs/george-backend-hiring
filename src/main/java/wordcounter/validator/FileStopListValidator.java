package wordcounter.validator;

import wordcounter.StopListValidator;

import java.util.List;

public class FileStopListValidator implements StopListValidator {
    @Override
    public boolean isOnStopList(List<String> stopWords, String targetWord) {
        return stopWords.contains(targetWord);
    }
}
