package bl.model;

import java.util.List;
import java.util.SortedSet;

public class WordStats {

    private final long total;
    private final long unique;
    private final double average;
    private final List<String> index;


    public WordStats(long total, long unique, double average) {
        this(total, unique, average, null);
    }

    public WordStats(long total, long unique, double average, List<String> index) {
        this.total = total;
        this.unique = unique;
        this.average = average;
        this.index = index;
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

    public List<String> getIndex() {
        return index;
    }
}
