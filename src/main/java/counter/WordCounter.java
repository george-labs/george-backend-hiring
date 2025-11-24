package counter;

import counter.model.CountingResult;

public interface WordCounter {

    /**
     * Calculating number of words
     * @param input text to parse
     * @return number of words
     */
    CountingResult countWords(String input);
}
