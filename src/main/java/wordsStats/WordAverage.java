package wordsStats;

public class WordAverage implements WordOperation<Double> {

    private long totalLen = 0;
    private long wordCount = 0;

    @Override
    public void ingestWord(String word) {
        wordCount++;
        totalLen += word.length();
    }

    @Override
    public String getStatSummary() {
        String delimiter = "";
        return "average word length: " + getStat() + " characters" + delimiter;
    }

    @Override
    public Double getStat() {
        return (double) totalLen / wordCount;
    }
}
