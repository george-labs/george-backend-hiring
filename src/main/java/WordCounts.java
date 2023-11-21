public class WordCounts {
    private final long wordCount;
    private final long uniqueWordCount;

    public WordCounts(long wordCount, long uniqueWordCount) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getUniqueWordCount() {
        return uniqueWordCount;
    }
}