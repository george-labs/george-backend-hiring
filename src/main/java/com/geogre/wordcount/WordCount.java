package com.geogre.wordcount;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordCount {

    private static final String SEPARATOR = " ";

    public void start() {
        System.out.print("Please, enter text: ");
        int totalWords = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            String[] words = input.split(SEPARATOR);
            totalWords = words.length;
        } catch (NoSuchElementException ex) {
            System.out.println();
        }

        System.out.print("Number of words: " + totalWords);
    }
}
