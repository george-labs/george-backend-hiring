package text;

import java.util.Objects;

public class TextAnalytics {
    private final int wordCount;
    private final int uniqueWordCount;
    private final double averageWordLength;

    public TextAnalytics() {
        wordCount = 0;
        uniqueWordCount = 0;
        averageWordLength = 0.0;
    }

    public TextAnalytics(int wordCount, int uniqueWordCount, double averageWordLength) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
        this.averageWordLength = averageWordLength;
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
