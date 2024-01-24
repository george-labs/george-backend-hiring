package processors;

import utils.Constants;

public class WordCounterManager {
    private final WordCounterEngine wordCounterEngine;

    public WordCounterManager(WordCounterEngine wordCounterEngine) {
        this.wordCounterEngine = wordCounterEngine;
    }

    public int process(String sentence) {
        String[] words = wordCounterEngine.senteceSplitter(sentence, Constants.REGEX);
        return wordCounterEngine.wordCounter(words);
    }
}
