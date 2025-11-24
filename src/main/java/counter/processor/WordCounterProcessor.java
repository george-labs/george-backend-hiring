package counter.processor;

public interface WordCounterProcessor {

    /**
     * Counts words from given input.
     * @param input input to process and count words from
     * @return message with counted words
     */
    String process(String input);
}
