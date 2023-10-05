package counter;

public class CounterResult {

    private final int numberOfWords;
    private final int numberOfUniqueWords;

    public CounterResult(int numberOfWords, int numberOfUniqueWords) {
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }
}
