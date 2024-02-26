package com.george.wordcount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSplitter {
    public static int countWords(String input) {
        if(input == null) {
            return 0;
        }
        String[] split = input.split("\\s+");
        return countWordsWithPatter(split);
    }

    private static int countWordsWithPatter(String[] split) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        int counter = 0;
        for (String s : split) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                counter++;
            }
        }
        return counter;
    }
}
