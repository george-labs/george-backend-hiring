package sk.george.intervierw;

import java.util.Objects;

/**
 * The class that handles the word counting
 */
public class WordCounter {

    /**
     * Counts the number of words in the given text
     * @param text - given text to count words in
     * @return number of words in the text
     */
    public int count(String text) {
        if (Objects.isNull(text) || text.isBlank()) {
            return 0;
        }

        // Split the text into words
        String[] words = text.split("\\s+");

        // Return the count of words
        return words.length;
    }
}
