package counter;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {

    public int count(String input) {
        String[] words = input.split(" ");

        return (int) Arrays.stream(words)
                .filter(word -> Pattern.matches("^[a-zA-Z]+$", word))
                .count();
    }
}
