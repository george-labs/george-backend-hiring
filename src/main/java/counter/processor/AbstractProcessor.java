package counter.processor;

import counter.WordCounter;
import counter.model.CountingResult;

public abstract class AbstractProcessor implements WordCounterProcessor {
    private final WordCounter wordCounter;

    public AbstractProcessor(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    /**
     * Message returned to GUI.
     * Notice: it would be injected from properties in e.g. Spring Framework
     */
    private String message = "Number of words: %s, unique: %s";

    public String processInternal(String input) {
        final CountingResult countingResult = wordCounter.countWords(input);
        return String.format(message, countingResult.getTotalWordsCount(), countingResult.getUniqueWordsCount());
    }
}
