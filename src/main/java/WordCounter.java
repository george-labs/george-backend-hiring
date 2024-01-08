import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    private static final String SEPARATOR_REGEX = "[\\s-.]";
    private static final Pattern WORD_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private final List<String> stopWords;

    private final List<String> text;

    private final List<String> words = new ArrayList<>();

    public WordCounter(List<String> text, List<String> stopWords) {
        this.text = text;
        this.stopWords = stopWords;
        this.splitToWords();
    }


    /**
     * Business Logic
     */
    private void splitToWords() {
        for (String line : text) {
            String[] possibleWords = line.split(SEPARATOR_REGEX);
            for (String possible : possibleWords) {
                Matcher matcher = WORD_PATTERN.matcher(possible);
                if (matcher.find() && !stopWords.contains(possible)) {
                    words.add(possible);
                }
            }

        }
    }

    public long count() {
        return words.size();
    }

    public long unique() {
        return new HashSet<>(words).size();
    }
}
