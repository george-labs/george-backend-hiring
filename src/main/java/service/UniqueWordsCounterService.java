package service;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UniqueWordsCounterService {

    public static int wordCounter(String inputText, Set<String> stopWords) {
        return Arrays.stream(inputText.split(" "))
                .filter(word -> (
                        Pattern.matches("[a-zA-Z]+", word)
                                && !stopWords.contains(word)
                ))
                .collect(Collectors.toSet())
                .size();
    }
}
