import java.util.Objects;

public class WordCount {
    private final long wordCount;
    private final long uniqueWords;
    private final double averageWordLength;

    public WordCount(long wordCount, long uniqueWords, double averageWordLength) {
        if (wordCount < 0) {
            throw new IllegalArgumentException("Invalid word count");
        }
        if (uniqueWords < 0 || uniqueWords > wordCount) {
            throw new IllegalArgumentException("Invalid unique word count");
        }
        if (averageWordLength < 0) {
            throw new IllegalArgumentException("Invalid average word length");
        }
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

    @Override
    public String toString() {
        return "WordCount{" +
                "wordCount=" + wordCount +
                ", uniqueWords=" + uniqueWords +
                ", averageWordLength=" + averageWordLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount1 = (WordCount) o;
        return wordCount == wordCount1.wordCount && uniqueWords == wordCount1.uniqueWords && Double.compare(
                averageWordLength, wordCount1.averageWordLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWords);
    }
}
