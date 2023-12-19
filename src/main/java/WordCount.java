import java.util.Objects;

public class WordCount {
    private final long wordCount;
    private final long uniqueWords;

    public WordCount(long wordCount, long uniqueWords) {
        if (wordCount < 0) {
            throw new IllegalArgumentException("Invalid word count");
        }
        if (uniqueWords < 0 || uniqueWords > wordCount) {
            throw new IllegalArgumentException("Invalid unique word count");
        }
        this.wordCount = wordCount;
        this.uniqueWords = uniqueWords;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "wordCount=" + wordCount +
                ", uniqueWords=" + uniqueWords +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount1 = (WordCount) o;
        return wordCount == wordCount1.wordCount && uniqueWords == wordCount1.uniqueWords;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWords);
    }
}
