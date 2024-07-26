package sk.george.intervierw;

import java.util.Arrays;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * The class that handles the word counting
 */
public class WordCounter {

    /**
     * Counts the number of words in the given text
     * @param text - given text to count words in
     * @return number of words in the text
     */
    public long count(String text) {
        if (Objects.isNull(text) || text.isBlank()) {
            return 0;
        }

        // Split the text into words
        String[] wordAssumptions = text.split("\\s+");

        return Arrays.stream(wordAssumptions)
                .filter(this::isWord)
                .count();
    }

    /**
     * Checks if the given text is a word - so it has substring of alphabetic characters
     * @param text to check
     * @return true if the text is a word, false otherwise
     */
    private boolean isWord(@NotNull String text) {
        return text.matches("^[a-zA-Z][a-zA-Z,.!?\\s]*$");
    }
}
