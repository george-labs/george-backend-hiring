package com.example;

import com.example.utils.ResourceFileHelper;
import com.example.utils.WordCounter;

import java.util.List;
import java.util.Scanner;

public class JavaApplication {
    private static final String stopwordsFileName = "stopwords.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stopwords = ResourceFileHelper.getFileLines(stopwordsFileName);

        if (stopwords != null) {
            System.out.println("Enter text: ");
            String text = scanner.nextLine();

            int words = WordCounter.countWordsFilteringOutStopwords(text, stopwords);
            System.out.println("Number of words: " + words);
        } else {
            System.err.println("Stopwords file not found.");
        }
    }
}
