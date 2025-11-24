package counter.processor;

import counter.WordCounter;
import counter.model.CountingResult;
import java.util.Locale;

public abstract class AbstractProcessor implements WordCounterProcessor {
    private final WordCounter wordCounter;

    public AbstractProcessor(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    /**
     * Message returned to GUI.
     * Notice: it would be injected from properties in e.g. Spring Framework
     */
    private final String message = "Number of words: %s, unique: %s; average word length: %.2f characters";

    public String processInternal(String input) {
        final CountingResult countingResult = wordCounter.countWords(input);
        return String.format(Locale.ENGLISH, message, countingResult.getTotalWordsCount(), countingResult.getUniqueWordsCount(), countingResult.getAvgWordLength());
    }
}
