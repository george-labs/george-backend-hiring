import java.math.BigDecimal;
import java.util.Set;

public class Counter {

    private long count = 0;
    private long countUnique = 0;

    private BigDecimal averageLength;

    private Set<String> usedWords;

    public Counter(long count, long countUnique) {
        this.count = count;
        this.countUnique = countUnique;
    }

    public Counter(long count, long countUnique, BigDecimal averageLength) {
        this.count = count;
        this.countUnique = countUnique;
        this.averageLength = averageLength;
    }

    public Counter(long count, long countUnique, BigDecimal averageLength, Set<String> usedWords) {
        this.count = count;
        this.countUnique = countUnique;
        this.averageLength = averageLength;
        this.usedWords = usedWords;
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

    public Set<String> getUsedWords() {
        return usedWords;
    }

    public void setUsedWords(Set<String> usedWords) {
        this.usedWords = usedWords;
    }
}
