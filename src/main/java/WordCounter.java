import kotlin.text.Regex;

import java.util.Arrays;

public class WordCounter {

    private final Regex regexWord = new Regex("[a-zA-Z]+[\\.!\\?,]?");
    private int counter = 0;
    private String input;

    public WordCounter(String input) {
        this.input = input;
    }


    public void processString() {
        var tokens = Arrays.asList(input.split("\\s+"));

        tokens.forEach(word -> {
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
