package sk.george.intervierw.word_counter;

import java.util.HashSet;
import java.util.List;

import sk.george.intervierw.exception.NonRecoverableException;
import sk.george.intervierw.io.input.InputHandler;

/**
 * The factory for creating word counters
 */
public class WordCounterFactory {

    private final InputHandler inputHandler;

    public WordCounterFactory(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    /**
     * Creates a new word counter with the given excluded words
     * @param pathToExcludedWords file path to the file containing excluded words
     * @return the new word counter with the excluded words included
     * @throws NonRecoverableException in a case of reading the excluded words file
     */
    public WordCounter createWithExcludedWords(String pathToExcludedWords) throws NonRecoverableException {
        List<String> excludedWordsFromFile = inputHandler.loadMultiple(pathToExcludedWords);
        return new WordCounter(new HashSet<>(excludedWordsFromFile));
    }
}
