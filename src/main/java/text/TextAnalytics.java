package text;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class TextAnalytics {
    private final int wordCount;
    private final int uniqueWordCount;
    private final double averageWordLength;
    private final List<String> words;

    public TextAnalytics() {
        wordCount = 0;
        uniqueWordCount = 0;
        averageWordLength = 0.0;
        words = List.of();
    }

    public TextAnalytics(int wordCount, int uniqueWordCount, double averageWordLength, List<String> words) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
        this.averageWordLength = averageWordLength;
        this.words = words;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public Collection<String> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextAnalytics that = (TextAnalytics) o;
        return wordCount == that.wordCount && uniqueWordCount == that.uniqueWordCount && Double.compare(averageWordLength, that.averageWordLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWordCount, averageWordLength);
    }
}
