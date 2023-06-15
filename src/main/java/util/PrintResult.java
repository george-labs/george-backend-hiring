package util;

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
}
