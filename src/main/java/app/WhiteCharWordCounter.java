package app;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WhiteCharWordCounter implements WordCounter {

    private static final Pattern WHITECHARACTERS_PATTERN = Pattern.compile("\\s+");
    private static final Pattern AZ_PATTERN = Pattern.compile("[a-zA-Z]+");

    @Override
    public long countWords(String inputString) {

        return Arrays.stream(WHITECHARACTERS_PATTERN.split(inputString))
                .filter(word -> AZ_PATTERN.matcher(word).matches())
                .count();
    }

}
