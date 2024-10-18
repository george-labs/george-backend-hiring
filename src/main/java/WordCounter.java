import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {
    private final static String WHITESPACE_REGEX = "\\s";
    private final static String VALID_WORD_REGEX = "^[A-Za-z]+$";
    private final static Pattern WORD_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    private final List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public WordCounter() {
        this.stopWords = new ArrayList<>();
    }

    public long getNumberOfWords(String text) {

        return Arrays.stream(text.split(WHITESPACE_REGEX))
                .filter(word -> !stopWords.contains(word))
                .filter(WORD_PATTERN.asPredicate())
                .count();
    }
}
