import kotlin.text.Regex;

import java.util.List;

public class WordCounter {

    private Regex regexWord = new Regex("[a-zA-Z]*");

    private int counter = 0;

    public void processString(List<String> input) {
        input.forEach(word -> {
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
