package counter.processor;


import counter.WordCounter;

/**
 * Counts words direct from input.
 */
public class StringWordCounterProcessor extends AbstractProcessor {

    public StringWordCounterProcessor(WordCounter wordCounter) {
        super(wordCounter);
    }

    @Override
    public String process(String input) {
        return processInternal(input);
    }
}
