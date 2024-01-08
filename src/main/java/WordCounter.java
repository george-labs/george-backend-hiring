import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {
    private static final String WHITESPACE_REGEX = "[\\s-.]";
    private static final Pattern WORD_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private final List<String> STOP_WORDS;

    private final List<String> text;

    private final List<String> words = new ArrayList<>();
    private long unique = 0;

    /**
     *
     * STOPWORDS - should be as parameter
     */
    public WordCounter(List<String> text) {
        this.text = text;
        STOP_WORDS = this.getStopWords();
        this.analyze();
    }

    private List<String> getStopWords() {
        URL resource = getClass().getClassLoader().getResource("stopwords.txt");
        try {
            if (resource != null) {
                return Files.readAllLines(Path.of(resource.toURI())).stream().map(String::trim).collect(Collectors.toList());
            } else {
                throw new IllegalStateException("The stopwords resource was not found.");
            }
        } catch (URISyntaxException | IOException e) {
            // TODO I should be able to run without the stopwords file in the classpath
            throw new IllegalStateException("The stopwords resource cannot be read.");
        }
    }

    /**
     * Business Logic
     * splitToWords
     * unique word count
     */
    private void analyze() {
        for (String line : text) {
            String[] possibleWords = line.split(WHITESPACE_REGEX);
            for (String possible : possibleWords) {
                Matcher matcher = WORD_PATTERN.matcher(possible);
                if (matcher.find() && !STOP_WORDS.contains(possible)) {
                    if (!words.contains(possible)) {
                        unique++;
                    }
                    words.add(possible);
                }
            }

        }
    }

    public long count() {
        return words.size();
    }

    public long unique() {
        return unique;
    }
}
