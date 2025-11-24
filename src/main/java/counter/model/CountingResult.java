package counter.model;

public class CountingResult {
    private final long uniqueWordsCount;
    private final long totalWordsCount;
    private final double avgWordLength;

    public CountingResult(long totalWordsCount, long uniqueWordsCount) {
        this(totalWordsCount, uniqueWordsCount, 0);
    }

    public CountingResult(long totalWordsCount, long uniqueWordsCount, double avgWordLength) {
        this.totalWordsCount = totalWordsCount;
        this.uniqueWordsCount = uniqueWordsCount;
        this.avgWordLength = avgWordLength;
    }

    public long getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public long getTotalWordsCount() {
        return totalWordsCount;
    }

    public double getAvgWordLength() {
        return avgWordLength;
    }
}
