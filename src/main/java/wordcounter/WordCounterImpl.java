package wordcounter;

import java.util.Arrays;
import java.util.Set;

public class WordCounterImpl implements WordCounter {

    private static final String SPLIT_WORDS_REGEX = "\\s+";
    private static final String ALPHABET_REGEX = "[a-zA-Z]+";

    @Override
    public long countWords(final String inputSentence, final Set<String> stopWords) {
        if (inputSentence == null) {
            return 0;
        }

        final String[] inputSentenceFragments = inputSentence.split(SPLIT_WORDS_REGEX);

        return Arrays.stream(inputSentenceFragments)
                .filter(word -> word.matches(ALPHABET_REGEX))
                .filter(word -> !stopWords.contains(word))
                .count();
    }
}
