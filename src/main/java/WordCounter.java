import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {
    private final static String WHITESPACE_REGEX = "\\s";
    private final static String VALID_WORD_REGEX = "[A-Za-z]+";
    private final static Pattern WORD_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    private List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public WordCounter() {
        this.stopWords = new ArrayList<>();
    }

    public long getNumberOfWords(String text) {
        final var list = text.split(WHITESPACE_REGEX);

        return Arrays.stream(list).filter(WORD_PATTERN.asPredicate()).count();

    }
}
