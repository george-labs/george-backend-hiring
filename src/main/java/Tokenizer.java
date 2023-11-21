import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Tokenizer {
    public static String SPACE_DELIMITER = " ";
    public static String ALPHABETIC_WORD_PATTERN = "[A-Za-z]+";

    private final String delimiter;
    private final Pattern pattern;

    public Tokenizer(String delimiter, String wordPattern) {
        this.delimiter = delimiter;
        this.pattern = Pattern.compile(wordPattern);
    }

    public Tokenizer() {
        this(SPACE_DELIMITER, ALPHABETIC_WORD_PATTERN);
    }

    public Stream<String> tokenize(String input) {
        String[] tokens = input
                .replaceAll("\\r\\n|\\r|\\n|\\.|,|!|\\?]", " ") // replace line breaks with spaces and other punctuation characters
                .replace('-', ' ')
                .split(this.delimiter);

        return Arrays.stream(tokens).filter(word -> this.pattern.matcher(word).matches());
    }

}
