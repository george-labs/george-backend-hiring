import kotlin.text.Regex;

import java.util.Arrays;

public class WordCounter {


    public WordCounter() {
    }

    public Integer countWordsInLine(String line, Regex regex) {
        return (int) Arrays.stream(line.split("\\s"))
                .filter(regex::matches)
                .count();
    }
}
