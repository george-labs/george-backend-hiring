package app;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WhiteCharWordCounter implements WordCounter {

    private static final Pattern AZ_PATTERN = Pattern.compile("[a-zA-Z]+");

    @Override
    public int countWords(String inputString) {
        return filterWords(inputString.split("\\s+"))
                .length;
    }

    private String[] filterWords(String[] words) {
        return Arrays.stream(words)
                .filter(word -> AZ_PATTERN.matcher(word).matches())
                .toArray(String[]::new);
    }

}
