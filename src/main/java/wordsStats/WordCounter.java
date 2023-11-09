package wordsStats;

import textProcessing.WordFetcher;

public class WordCounter implements WordOperation<Long>{

    private long counter = 0;

    public WordCounter() {
    };

    @Override
    public void ingestWord(String word) {
        counter++;
    }
    @Override
    public String getStatSummary() {
        String delimiter = ", ";
        return "Number of words: " + counter + delimiter;
    }

    public Long getStat() {
        return counter;
    }

}
