package sk.erste.wordcountkata;

import sk.erste.wordcountkata.filter.StopWordFilter;
import sk.erste.wordcountkata.filter.WordFilter;

import java.util.HashSet;
import java.util.Set;

public class WordCounter {

    private final StopWordFilter stopWordFilter;
    private final WordFilter wordFilter = new WordFilter();

    public WordCounter(StopWordFilter stopWordFilter) {
        this.stopWordFilter = stopWordFilter;
    }

    public WordCountStat countWords(String text) {
        Set<String> uniqueWords = new HashSet<>();

        String[] split = text.split("[^a-zA-Z0-9-]+");
        int count = 0;
        for (String word : split) {
            if (isWordValid(word)) {
                count++;
                uniqueWords.add(word);
            }
        }

        return new WordCountStat(count, uniqueWords.size());
    }

    public boolean isWordValid(String word) {
        boolean passed = wordFilter.isWordValid(word);
        if (stopWordFilter != null) {
            passed = passed && !stopWordFilter.isStopWord(word);
        }
        return passed;
    }

    public record WordCountStat (int wordCount, int uniqueWordCount) {
    }
}
