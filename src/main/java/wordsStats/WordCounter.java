package wordsStats;

import textProcessing.WordFetcher;

public class WordCounter implements WordOperation<Long>{

    private long counter = 0;

    public WordCounter() {};

    @Override
    public void ingestWord(String word) {
        counter++;
    }
    @Override
    public String getStatSummary() {
        return "Number of words: " + counter;
    }

    public Long getStat() {
        return counter;
    }

}
