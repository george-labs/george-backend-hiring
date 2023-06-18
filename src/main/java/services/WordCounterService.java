package services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * The WordCounterService class provides a method to count the number of words in a given phrase.
 */
public class WordCounterService {
    private final Set<String> stopWords;

    /**
     * Constructs a WordCounterService object and loads the stop words from the stopwords file (optional).
     */
    public WordCounterService(String stopWordsFilename) {
        stopWords = loadStopWords(stopWordsFilename);
    }

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
        return word.matches("[a-zA-Z]+") && !stopWords.contains(word.toLowerCase());
    }

    /**
     * Loads the stop words from the stopwords file.
     * An assumption is made that the letter case of stopwords is irrelevant.
     * This means that if the file contains the word 'the',
     * then none of the following words will be counted: 'the', 'The', and 'THE'.
     *
     * @return a set of stop words
     */
    private Set<String> loadStopWords(String stopWordsFilename) {
        Set<String> stopWordsInternal = new HashSet<>();

        try {
            URL stopWordsURL = getClass().getResource(stopWordsFilename);
            if (stopWordsURL != null) {
                Path stopwordsPath = Path.of(stopWordsURL.toURI());
                try (Stream<String> lines = Files.lines(stopwordsPath)) {
                    lines.map(String::toLowerCase)
                            .forEach(stopWordsInternal::add);
                }
            } else {
                System.out.println("No stop words file found.");
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return stopWordsInternal;
    }
}
