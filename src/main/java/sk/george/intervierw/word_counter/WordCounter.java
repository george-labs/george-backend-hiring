package sk.george.intervierw.word_counter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;

/**
 * The class that handles the word counting
 */
public class WordCounter {
    private final Set<String> excludedWords;

    public WordCounter(Set<String> excludedWords) {
        this.excludedWords = Objects.nonNull(excludedWords)
                ? excludedWords
                : new HashSet<>();
    }

    public WordCounter() {
        this.excludedWords = new HashSet<>();
    }

    /**
     * Counts the number of words in the given text
     * @param text - given text to count words in
     * @return number of words in the text excluding the excluded words
     */
    public long count(String text) {
        if (Objects.isNull(text) || text.isBlank()) {
            return 0;
        }

        // Split the text into words
        String[] wordAssumptions = splitWords(text);

        return filterWords(Arrays.stream(wordAssumptions)).count();
    }

    /**
     * Counts the number of words in the given texts
     * @param texts the list of texts to count words in
     * @return number of words in the text excluding the excluded words
     */
    public long count(List<String> texts) {
        if (Objects.isNull(texts) || texts.isEmpty()) {
            return 0;
        }

        // Split the texts into words
        List<String> words = texts.stream()
                .flatMap((String text) -> Arrays.stream(splitWords(text)))
                .toList();

        return filterWords(words.stream()).count();
    }

    /**
     * Filters the given stream of words by excluding the excluded words
     * @param wordsStream given stream of words to filter
     * @return filtered stream of valid words and excluding the excluded words
     */
    private Stream<String> filterWords(Stream<String> wordsStream) {
        return wordsStream
                .filter(this::isValidWord)
                .filter((String word) -> !isExcluded(word.toLowerCase()));
    }

    /**
     * Checks if the given text is a word - so it has substring of alphabetic characters
     * @param text to check
     * @return true if the text is a word, false otherwise
     */
    private boolean isValidWord(@NotNull String text) {
        return text.matches("^[a-zA-Z][a-zA-Z,.!?\\s]*$");
    }

    /**
     * Checks if the given word is excluded from counting
     * @param word checked word
     * @return true if the word is contained in the excludedWords set, false otherwise
     */
    private boolean isExcluded(@NotNull String word) {
        return excludedWords.contains(word.toLowerCase());
    }

    /**
     * Splits the given text into words by empty spaces
     * @param text to split
     * @return the array of words
     */
    private String[] splitWords(String text) {
        return text.split("\\s+");
    }
}
