import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    // Considered thread safe
    public static final Pattern PATTERN = Pattern.compile("[a-zA-Z]+");

    public long getWordCount(final String line) {
        if (line == null) {
            return 0;
        }

        Matcher matcher = PATTERN.matcher(line);
        return matcher.results().count();
    }
}
