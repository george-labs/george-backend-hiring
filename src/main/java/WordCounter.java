import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {
    private final String delimiter;
    private final Pattern pattern;

    public WordCounter() {
        this(" ", "[A-Za-z]+");
    }

    public WordCounter(String delimiter, String wordPattern) {
        this.delimiter = delimiter;
        this.pattern = Pattern.compile(wordPattern);
    }

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }

        String[] candidateWords = input.split(this.delimiter);
        return Arrays.stream(candidateWords).filter(word -> this.pattern.matcher(word).matches()).count();
    }
}