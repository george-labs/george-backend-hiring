package utils;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    public static Collection<String> splitBy(String text, @NotNull String splitter) {
        if (text == null) {
            return List.of();
        }
        return Arrays.stream(text.split(splitter)).sequential().map(String::trim)
                .filter(word -> ! word.isBlank()).collect(Collectors.toList());
    }
}
