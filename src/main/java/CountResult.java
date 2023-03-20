public class CountResult {

    private final int wordCount;
    private final int distinctCount;

    public CountResult(int wordCount, int distinctCount) {
        this.wordCount = wordCount;
        this.distinctCount = distinctCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getDistinctCount() {
        return distinctCount;
    }
}
