import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    private static final String WHITESPACE_REGEX = "\\s";
    private static final Pattern WORD_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private final String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public long get(){
        // Pattern pattern = Pattern.compile("([a-zA-z]+)");  //^[a-zA-Z]+$
        String[] possibleWords = text.split(WHITESPACE_REGEX);

        long count = 0;
        for (String possible: possibleWords) {
            Matcher matcher = WORD_PATTERN.matcher(possible);
            if (matcher.find()){
                count++;
            }
        }
        return count;

    }
}
