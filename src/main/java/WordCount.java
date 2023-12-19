import java.util.Objects;
import java.util.Set;

public class WordCount {
    private final long wordCount;
    private final long uniqueWords;
    private final double averageWordLength;
    private final Set<String> countedWords;

    public WordCount(long wordCount, long uniqueWords, double averageWordLength, Set<String> countedWords) {
        if (wordCount < 0) {
            throw new IllegalArgumentException("Invalid word count");
        }
        if (uniqueWords < 0 || uniqueWords > wordCount) {
            throw new IllegalArgumentException("Invalid unique word count");
        }
        if (averageWordLength < 0) {
            throw new IllegalArgumentException("Invalid average word length");
        }
        if (countedWords == null) {
            throw new IllegalArgumentException("Invalid counted words param");
        }
        this.countedWords = countedWords;
        this.averageWordLength = averageWordLength;
        this.wordCount = wordCount;
        this.uniqueWords = uniqueWords;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public Set<String> getCountedWords() {
        return countedWords;
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "wordCount=" + wordCount +
                ", uniqueWords=" + uniqueWords +
                ", averageWordLength=" + averageWordLength +
                ", countedWords=" + countedWords +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount1 = (WordCount) o;
        return wordCount == wordCount1.wordCount && uniqueWords == wordCount1.uniqueWords && Double.compare(
                averageWordLength, wordCount1.averageWordLength) == 0 && Objects.equals(countedWords,
                wordCount1.countedWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWords);
    }
}
