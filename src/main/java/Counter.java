import java.math.BigDecimal;

public class Counter {

    private long count = 0;
    private long countUnique = 0;

    private BigDecimal averageLength;

    public Counter(long count, long countUnique) {
        this.count = count;
        this.countUnique = countUnique;
    }

    public Counter(long count, long countUnique, BigDecimal averageLength) {
        this.count = count;
        this.countUnique = countUnique;
        this.averageLength = averageLength;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCountUnique() {
        return countUnique;
    }

    public void setCountUnique(long countUnique) {
        this.countUnique = countUnique;
    }

    public BigDecimal getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(BigDecimal averageLength) {
        this.averageLength = averageLength;
    }
}
