package service;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounterService {

    public static int wordCounter(String inputText) {
        return Arrays.stream(inputText.split(" "))
                .filter(word -> (Pattern.matches("[a-zA-Z]+", word)))
                .toArray()
                .length;
    }
    public static int wordCounter(String inputText, Set<String> stopWords) {
        return Arrays.stream(inputText.split(" "))
                .filter(word -> (
                        Pattern.matches("[a-zA-Z]+", word)
                                && !stopWords.contains(word)
                ))
                .toArray()
                .length;
    }
}
