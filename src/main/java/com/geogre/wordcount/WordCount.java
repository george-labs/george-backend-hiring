package com.geogre.wordcount;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCount {

    private final WordCounter wordCounter;

    private final String inputFilePath;

    public WordCount(WordCounter wordCounter, String inputFilePath) {
        this.wordCounter = wordCounter;
        this.inputFilePath = inputFilePath;
    }

    public void start() {
        long totalWords = 0;
        String input;
        if (inputFilePath != null) {
            try {
                input = readFromFile();
            } catch (FileNotFoundException e) {
                System.out.println("File " + inputFilePath + " does not exists");
                return;
            }
        } else {
            input = readFromConsole();
        }

        totalWords = wordCounter.count(input);

        System.out.print("Number of words: " + totalWords);
    }

    private String readFromFile() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
        return bufferedReader.lines().collect(Collectors.joining(" "));
    }

    private String readFromConsole() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException ex) {
            System.out.println();
        }
        return "";
    }

}
