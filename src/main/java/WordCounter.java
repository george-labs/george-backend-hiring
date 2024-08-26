import kotlin.text.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCounter {

    private final Regex regexWord = new Regex("[a-zA-Z]+[\\.!\\?,]?");
    private int counter = 0;
    private final List<String> input;
    private final List<String> stopWords;

    public WordCounter(List<String> input) {
        this(input, new ArrayList<>());
    }

    public WordCounter(List<String> input, List<String> stopWords) {
        this.input = input;
        this.stopWords = stopWords;
    }

    public void countWords() {
        input.forEach(this::processLine);
    }

    private void processLine(String line) {
        var tokens = Arrays.asList(line.split("\\s+"));

        tokens.forEach(word -> {
            if (stopWords.contains(word)) {
                return;
            }

            if (regexWord.matches(word)) {
                raiseCounter();
            }
        });
    }

    public int getWordCount() {
        return this.counter;
    }

    private void raiseCounter() {
        this.counter = this.counter + 1;
    }

}
