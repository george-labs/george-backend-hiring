package util;

import java.util.Objects;

public class PrintResult {

    private final int wordCount;
    private final int uniqueWordCount;
    private final double averageWordLength;

    public PrintResult(int wordCount, int uniqueWordCount, double averageWordLength) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
        this.averageWordLength = averageWordLength;
    }

    @Override
    public String toString() {
        return "Number of words: " + wordCount +
                ", unique: " + uniqueWordCount +
                "; average word length: " + averageWordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintResult that = (PrintResult) o;

        return wordCount == that.wordCount && uniqueWordCount == that.uniqueWordCount && Double.compare(that.averageWordLength, averageWordLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWordCount, averageWordLength);
    }
}
