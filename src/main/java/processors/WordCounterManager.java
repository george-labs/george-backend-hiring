package processors;

public class WordCounterManager {
    private final WordCounterEngine wordCounterEngine;

    public WordCounterManager(WordCounterEngine wordCounterEngine) {
        this.wordCounterEngine = wordCounterEngine;
    }

    public int process(String sentence){
        String[] words = wordCounterEngine.senteceSplitter(sentence, " ");
        int numberOfWords = wordCounterEngine.wordCounter(words);
        return numberOfWords;

    }
}
