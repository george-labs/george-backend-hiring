package wordsStats;

import textProcessing.WordFetcher;

public class WordCounter {
    private final WordFetcher wordFetcher;
    private long counter = 0;

    public WordCounter(WordFetcher wordFetcher) {
        this.wordFetcher = wordFetcher;
    }

    public long getCount() {
        String word;
        while((word = wordFetcher.getNextWord()) != null) {
            counter++;
        }
        return counter;
    }
}
