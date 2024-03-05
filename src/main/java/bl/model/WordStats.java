package bl.model;

public class WordStats {

    private final long total;
    private final long unique;
    private final double average;

    public WordStats(long total, long unique, double average) {
        this.total = total;
        this.unique = unique;
        this.average = average;
    }

    public long getTotal() {
        return total;
    }

    public long getUnique() {
        return unique;
    }

    public double getAverage() {
        return average;
    }
}
