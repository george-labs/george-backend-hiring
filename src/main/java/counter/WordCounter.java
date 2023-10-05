package counter;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private final Set<String> stopWords;

    public WordCounter(String stopWordsString) {
        this.stopWords = Arrays.stream(stopWordsString.split(",")).collect(Collectors.toSet());
    }

    public int count(String input) {
        String[] words = input.split(" ");

        return (int) Arrays.stream(words)
                .filter(word -> Pattern.matches("^[a-zA-Z]+$", word))
                .filter(word -> !stopWords.contains(word))
                .count();
    }
}
