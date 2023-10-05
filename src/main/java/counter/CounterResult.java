package counter;

import java.util.List;

public class CounterResult {

    private final List<String> words;
    private final int numberOfWords;
    private final int numberOfUniqueWords;
    private final double averageWordLength;

    public CounterResult(List<String> words, int numberOfWords, int numberOfUniqueWords, double averageWordLength) {
        this.words = words;
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
        this.averageWordLength = averageWordLength;
    }

    public List<String> getWords() {
        return words;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }
}
