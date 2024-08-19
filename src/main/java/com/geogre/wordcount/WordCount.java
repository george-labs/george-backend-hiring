package com.geogre.wordcount;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordCount {

    private static final String SEPARATOR = " ";

    public void start() {
        System.out.print("Enter text: ");
        long totalWords = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            WordCounter wordCounter = new WordCounter(SEPARATOR, getStopWords());
            totalWords = wordCounter.count(input);
        } catch (NoSuchElementException ex) {
            System.out.println();
        }

        System.out.print("Number of words: " + totalWords);
    }

    private @NotNull List<String> getStopWords() {
        return List.of("the", "a", "of", "on");
    }
}
