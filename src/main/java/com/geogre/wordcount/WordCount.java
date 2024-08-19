package com.geogre.wordcount;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordCount {

    private final WordCounter wordCounter;

    public WordCount(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public void start() {
        System.out.print("Enter text: ");
        long totalWords = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            totalWords = wordCounter.count(input);
        } catch (NoSuchElementException ex) {
            System.out.println();
        }

        System.out.print("Number of words: " + totalWords);
    }
}
