import java.util.Arrays;

public class Sentence implements SentenceWordsCounting {
    public static final String EMPTY_SPACES_REGEX = "\\s+";
    private static final String LETTER_REGEX = "^[a-zA-Z]*$";

    @Override
    public long countingWordsOnlyLetter(String sentence) {

        return Arrays.stream(sentence.split(EMPTY_SPACES_REGEX))
                .filter(word -> word.matches(LETTER_REGEX) && !word.equals(""))
                .count();
    }
}
