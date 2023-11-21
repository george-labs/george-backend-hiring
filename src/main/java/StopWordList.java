import java.util.List;

public class StopWordList {
    private final List<String> stopWords;

    public StopWordList(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public boolean isStopWord(String word) {
        return this.stopWords.contains(word);
    }
}