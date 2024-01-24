package processors;

import providers.WordsPrinter;

public class WordCounterManager {
    private final WordCounterEngine wordCounterUtility;

    public WordCounterManager(WordCounterEngine wordCounterUtility) {
        this.wordCounterUtility = wordCounterUtility;
    }

    public int process(String sentence){
        String[] words = wordCounterUtility.senteceSplitter(sentence, " ");
        int numberOfWords = wordCounterUtility.wordCounter(words);
        return numberOfWords;

    }
}
