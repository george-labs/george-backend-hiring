import java.util.Arrays;

class WordCounterImpl implements WordCounter {

    private static final String SPLIT_WORDS_REGEX = "\\s+";
    private static final String ALPHABET_REGEX = "[a-zA-Z]+";

    @Override
    public long countWords(String inputSentence) {
        if (inputSentence == null) {
            return 0;
        }

        final String[] inputSentenceFragments = inputSentence.split(SPLIT_WORDS_REGEX);

        return Arrays.stream(inputSentenceFragments)
                .filter(word -> word.matches(ALPHABET_REGEX))
                .count();
    }
}
