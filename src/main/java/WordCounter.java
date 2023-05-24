import kotlin.text.Regex;

import java.util.Arrays;
import java.util.List;

public class WordCounter {

    final Regex regex;
    final List<String> stopWords;

    public WordCounter(Regex regex, List<String> stopWords) {
        this.regex = regex;
        this.stopWords = stopWords;
    }

    public Integer countWordsInLine(String line) {
        return (int) Arrays.stream(line.split("\\s"))
                .filter(regex::matches)
                .filter(it -> !this.stopWords.contains(it))
                .count();
    }
}
