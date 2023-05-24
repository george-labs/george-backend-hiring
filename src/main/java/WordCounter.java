import kotlin.text.Regex;

import java.util.Arrays;
import java.util.List;

public class WordCounter implements Counter {

    final Regex regex;
    final List<String> stopWords;

    final String line;

    public WordCounter(Regex regex, List<String> stopWords, String line) {
        this.regex = regex;
        this.stopWords = stopWords;
        this.line = line;
    }

    @Override
    public Integer count() {
        return (int) Arrays.stream(line.split("\\s"))
                .filter(regex::matches)
                .filter(it -> !this.stopWords.contains(it))
                .count();
    }
}
