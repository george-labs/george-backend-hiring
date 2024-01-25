import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounter {

    private List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z]*$");

    public long countWords(String in) {
        if (in == null || in.isEmpty()) {
            return 0;
        }
        String[] split = in.split("\\s+");

        return Arrays.stream(split)
                .filter(s -> !stopWords.contains(s) && PATTERN.matcher(s).matches())
                .count();
    }

    public long countWords(List<String> lines) {
        return lines
                .stream()
                .map(this::countWords)
                .reduce(0L, Long::sum);
    }

}
