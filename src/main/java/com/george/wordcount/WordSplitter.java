package com.george.wordcount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSplitter {

    private int count;
    private int uniqueCount;

    public WordSplitter(String input, String[] stopWords) {
        countWords(input, stopWords);
    }

    public void countWords(String input, String[] stopWords) {
        if (input == null) {
            count = 0;
            uniqueCount = 0;
            return;
        }
        countWordsWithPatter(input.split("\\s+"), stopWords);
    }

    private void countWordsWithPatter(String[] split, String[] stopWords) {
        HashSet<String> uniqueWords = new HashSet<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        int counter = 0;
        for (String s : split) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find() && !Arrays.asList(stopWords).contains(s)) {
                uniqueWords.add(s);
                counter++;
            }
        }
        this.count = counter;
        this.uniqueCount = uniqueWords.size();
    }


    public int getUniqueCount() {
        return uniqueCount;
    }

    public int getCount() {
        return count;
    }
}
