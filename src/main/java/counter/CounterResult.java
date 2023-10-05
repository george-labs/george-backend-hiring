package counter;

public class CounterResult {

    private final int numberOfWords;
    private final int numberOfUniqueWords;
    private final double averageWordLength;

    public CounterResult(int numberOfWords, int numberOfUniqueWords, double averageWordLength) {
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
        this.averageWordLength = averageWordLength;
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
