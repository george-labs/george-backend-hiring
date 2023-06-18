package services;

import java.util.Arrays;

/**
 * The WordCounterService class provides a method to count the number of words in a given phrase.
 */
public class WordCounterService {

    /**
     * Counts the number of words in a given phrase.
     *
     * @param phrase the input phrase
     * @return the number of words in the phrase
     */
    public long countWords(String phrase) {
        if (phrase.isEmpty()) {
            return 0;
        }

        var wordList = Arrays.asList(phrase.split(" "));

        return wordList.stream().filter(this::isValidWord).count();
    }

    /**
     * Determines whether a word is valid, meaning it consists solely of alphabetical characters.
     *
     * @param word the word to be checked
     * @return {@code true} if the word is valid, {@code false} otherwise
     */
    private boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
