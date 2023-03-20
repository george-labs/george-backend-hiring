public class CountResult {

    private int wordCount;
    private int distinctCount;

    public CountResult(int wordCount, int distinctCount) {
        this.wordCount = wordCount;
        this.distinctCount = distinctCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getDistinctCount() {
        return distinctCount;
    }

    public void setDistinctCount(int distinctCount) {
        this.distinctCount = distinctCount;
    }
}
