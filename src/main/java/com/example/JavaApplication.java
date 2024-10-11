package com.example;

import com.example.utils.WordCounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {
    private static final String stopwordsFileName = "stopwords.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stopwords = null;

        try {
            stopwords = Files.readAllLines(new File(stopwordsFileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        int words = WordCounter.countWords(text);
        System.out.println("Number of words: " + words);
    }
}
