package com.geogre.wordcount;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCount {

    private static final String SEPARATOR = " ";
    private static final Pattern WORDS = Pattern.compile("[a-z,A-Z]+");

    public void start() {
        System.out.print("Enter text: ");
        long totalWords = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            if (!isEmpty(input)) {
                String[] tokens = input.split(SEPARATOR);
                totalWords = Arrays.stream(tokens).filter(token -> WORDS.matcher(token).matches()).count();
            }
        } catch (NoSuchElementException ex) {
            System.out.println();
        }

        System.out.print("Number of words: " + totalWords);
    }

    private boolean isEmpty(String input) {
        return input.trim().isEmpty();
    }
}
