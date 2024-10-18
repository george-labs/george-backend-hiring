package domain.entity;

public class WordCountResult {
    private final long totalWords;
    private final long uniqueWords;

    public WordCountResult(long totalWords, long uniqueWords) {
        this.totalWords = totalWords;
        this.uniqueWords = uniqueWords;
    }

    public long getTotalWords() {
        return totalWords;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }
}
