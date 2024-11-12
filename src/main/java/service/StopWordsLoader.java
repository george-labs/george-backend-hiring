package service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsLoader {

    public static Set<String> getStopWords(String content) {
        return Arrays.stream(content.split("\n"))
                .map(String::trim)
                .collect(Collectors.toSet());
    }
}
