package com.geogre.wordcount;

public class WordCount {

    private final WordCounter wordCounter;
    private final InputFetcher inputFetcher;

    public WordCount(WordCounter wordCounter, InputFetcher inputFetcher) {
        this.wordCounter = wordCounter;
        this.inputFetcher = inputFetcher;
    }

    public void start() {
        long totalWords = 0;

        String input = inputFetcher.fetch();
        totalWords = wordCounter.count(input);

        System.out.print("Number of words: " + totalWords);
    }
}
