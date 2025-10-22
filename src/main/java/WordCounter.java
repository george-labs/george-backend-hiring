import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    // Considered thread safe
    public static final Pattern PATTERN = Pattern.compile("[a-zA-Z]+");
    private final List<String> stopwords;

    public WordCounter(List<String> stopwords) {
        this.stopwords = stopwords;
    }

    public long getWordCount(final String line) {
        if (line == null) {
            return 0;
        }

        Matcher matcher = PATTERN.matcher(line);
        return matcher.results().filter(word -> !stopwords.contains(word.group())).count();
    }
}
