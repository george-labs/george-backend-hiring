import kotlin.text.Regex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return (int) filteredLine().count();
    }

    @Override
    public Integer unique() {
        return  filteredLine()
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Stream<String> filteredLine() {
        return Arrays.stream(line.split("\\s"))
                .filter(regex::matches)
                .filter(it -> !this.stopWords.contains(it));
    }

    @Override
    public void display() {
        System.out.printf("Number of words: %d, unique: %d%n", count(), unique());
    }
}
