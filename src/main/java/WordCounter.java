import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {
    private final static String WHITESPACE_REGEX = "\\s";
    private final static String VALID_WORD_REGEX = "[A-Za-z]+";
    private final static Pattern WORD_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    public long getNumberOfWords(String text) {
        final var list = text.split(WHITESPACE_REGEX);

        return Arrays.stream(list).filter(WORD_PATTERN.asPredicate()).count();

    }
}
