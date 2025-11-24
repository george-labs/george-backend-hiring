package counter;

public class WordCounterProcessor {
    private final WordCounter wordCounter;

    /**
     * Message returned to GUI.
     * Notice: it would be injected from properties in e.g. Spring Framework
     */
    private String message = "Number of words: %s";

    public WordCounterProcessor(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public String process(String input) {
        final long countWords = wordCounter.countWords(input);
        return String.format(message, countWords);
    }
}
