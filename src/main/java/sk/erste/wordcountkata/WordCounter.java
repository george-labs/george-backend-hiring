package sk.erste.wordcountkata;

import sk.erste.wordcountkata.filter.StopWordFilter;
import sk.erste.wordcountkata.filter.WordFilter;

public class WordCounter {

    private final StopWordFilter stopWordFilter;
    private final WordFilter wordFilter = new WordFilter();

    public WordCounter(StopWordFilter stopWordFilter) {
        this.stopWordFilter = stopWordFilter;
    }

    public int countWords(String text) {
        String[] split = text.split("\\s+");
        int count = 0;
        for (String word : split) {
            if (isWordValid(word)) {
                count++;
            }
        }
        return count;
    }

    public boolean isWordValid(String word) {
        return wordFilter.isWordValid(word) && !stopWordFilter.isStopWord(word);
    }
}
