package wordcount;

import java.util.Objects;

public class TextAnalytics {
    private final int wordCount;
    private final int uniqueWordCount;

    public TextAnalytics() {
        wordCount = 0;
        uniqueWordCount = 0;
    }

    public TextAnalytics(int wordCount, int uniqueWordCount) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextAnalytics that = (TextAnalytics) o;
        return wordCount == that.wordCount && uniqueWordCount == that.uniqueWordCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWordCount);
    }
}
