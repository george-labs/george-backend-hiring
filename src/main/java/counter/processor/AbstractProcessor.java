package counter.processor;

import counter.WordCounter;

public abstract class AbstractProcessor implements WordCounterProcessor {
    private final WordCounter wordCounter;

    public AbstractProcessor(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    /**
     * Message returned to GUI.
     * Notice: it would be injected from properties in e.g. Spring Framework
     */
    private String message = "Number of words: %s";

    public String processInternal(String input) {
        final long countWords = wordCounter.countWords(input);
        return String.format(message, countWords);
    }
}
