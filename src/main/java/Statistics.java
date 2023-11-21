public class Statistics {
    private final long wordCount;
    private final long uniqueWordCount;
    private final double averageWordLength;

    public Statistics(long wordCount, long uniqueWordCount, double averageWordLength) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
        this.averageWordLength = averageWordLength;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getUniqueWordCount() {
        return uniqueWordCount;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }
}