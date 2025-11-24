package counter.model;

public class CountingResult {
    private final long uniqueWordsCount;
    private final long totalWordsCount;

    public CountingResult(long totalWordsCount, long uniqueWordsCount) {
        this.totalWordsCount = totalWordsCount;
        this.uniqueWordsCount = uniqueWordsCount;
    }

    public long getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public long getTotalWordsCount() {
        return totalWordsCount;
    }
}
