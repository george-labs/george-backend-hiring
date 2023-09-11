package service.stop_word;

import java.util.HashSet;
import java.util.Set;

public class StopWordService implements IStopWordService {
    private final Set<String> stopWords = new HashSet<>();

    public StopWordService(IStopWordProvider stopWordProvider) {
        stopWordProvider.getStopWords()
                .forEach(word -> stopWords.add(word.toLowerCase()));
    }
    @Override
    public boolean isStopWord(String str) {
        return stopWords.contains(str.toLowerCase());
    }
}
