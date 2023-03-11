import java.util.HashSet;
import java.util.Set;

public class WordCountResult {
    private final Long numberOfWords;
    private final Long numberOfUniqueWords;
    private final Integer sumOfLength;
    private final Set<String> index;

    public WordCountResult(Long numberOfWords, Long numberOfUniqueWords, Integer sumOfLength, Set<String> index) {
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
        this.sumOfLength = sumOfLength;
        this.index = new HashSet<>(index);
    }

    public Long getNumberOfWords() {
        return numberOfWords;
    }

    public Long getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }

    public Double getAverageWordLength() {
        if (numberOfWords == 0) {
            return 0.0;
        }
        return (double)sumOfLength/ numberOfWords;
    }

    public Set<String> getIndex() {
        return index;
    }
}
