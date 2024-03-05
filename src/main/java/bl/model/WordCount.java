package bl.model;

import java.util.Objects;

public class WordCount {

    private final long total;
    private final long unique;

    public WordCount(long total, long unique) {
        this.total = total;
        this.unique = unique;
    }

    public long getTotal() {
        return total;
    }

    public long getUnique() {
        return unique;
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "total=" + total +
                ", unique=" + unique +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount = (WordCount) o;
        return total == wordCount.total && unique == wordCount.unique;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, unique);
    }
}
