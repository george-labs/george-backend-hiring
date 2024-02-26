package com.george.wordcount;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSplitter {
    public static int countWords(String input, String[] exceptionWords) {
        if(input == null) {
            return 0;
        }
        String[] split = input.split("\\s+");
        return countWordsWithPatter(split, exceptionWords);
    }

    private static int countWordsWithPatter(String[] split, String[] exceptionWords) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        int counter = 0;
        for (String s : split) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find() && !Arrays.asList(exceptionWords).contains(s)) {
                counter++;
            }
        }
        return counter;
    }
}
