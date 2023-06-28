package services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The WordCounterService class provides a method to count the number of words in a given phrase.
 */
public class WordCounterService {
    private static final String VALID_WORD_REGEX = "[a-zA-Z]+";
    private static final String SPLIT_REGEX = "\\s+";
    private static final String PUNCTUATION_REGEX = "[.,?!]";
    private static final String HYPHEN = "-";


    /**
     * Counts the number of words in a given phrase.
     *
     * @param phrase the input phrase
     * @return the number of words in the phrase
     */
    public long countWords(String phrase, Set<String> stopWords) {
        if (phrase.isEmpty()) {
            return 0;
        }

        var sanitizedPhrasePunctuation = sanitizePunctuation(phrase);
        var sanitizedPhraseHyphenCharacter = sanitizeHyphenCharacter(sanitizedPhrasePunctuation);

        var wordList = splitPhraseIntoWords(sanitizedPhraseHyphenCharacter);

        return wordList.stream().filter(word -> isValidWord(word, stopWords)).count();
    }

    public long countUniqueWords(String phrase, Set<String> stopWords) {
        if (phrase.isEmpty()) {
            return 0;
        }

        var sanitizedPhrasePunctuation = sanitizePunctuation(phrase);
        var sanitizedPhraseHyphenCharacter = sanitizeHyphenCharacter(sanitizedPhrasePunctuation);

        var wordList = splitPhraseIntoWords(sanitizedPhraseHyphenCharacter);
        var wordSet = new HashSet<>(wordList);

        return wordSet.stream().filter(word -> isValidWord(word, stopWords)).count();
    }

    private String sanitizeHyphenCharacter(String phrase) {
        var words = splitPhraseIntoWords(phrase);
        var wordsWithoutHyphenIssue = words.stream().filter(s -> !s.startsWith(HYPHEN) &&
                        !s.endsWith(HYPHEN))
                .collect(Collectors.joining (" "));

        return wordsWithoutHyphenIssue.replace(HYPHEN, "");
    }

    private String sanitizePunctuation(String phrase) {
        return phrase.replaceAll(PUNCTUATION_REGEX, "");
    }

    private List<String> splitPhraseIntoWords(String phrase) {
        return Arrays.asList(phrase.split(SPLIT_REGEX));
    }


    /**
     * Determines whether a word is valid, meaning it consists solely of alphabetical characters and is not a stop word.
     *
     * @param word the word to be checked
     * @return {@code true} if the word is valid, {@code false} otherwise
     */
    private boolean isValidWord(String word, Set<String> stopWords) {
        return word.matches(VALID_WORD_REGEX) &&
                !stopWords.contains(word.toLowerCase());
    }
}
