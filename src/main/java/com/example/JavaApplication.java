package com.example;

import com.example.utils.FileHelper;
import com.example.utils.WordCounter;

import java.util.List;
import java.util.Scanner;

/**
 *
 * - wordcount
 * - stopwords.txt
 * - text.txt
 */

public class JavaApplication {
    private static final String DEFAULT_STOPWORDS_FILE = "stopwords.txt";

    public void run(String stopwordsFileName, String textFileName) {
        Scanner scanner = new Scanner(System.in);
        List<String> stopwords = FileHelper.getFileLines(stopwordsFileName);
        List<String> textFileContent = FileHelper.getFileLines(textFileName);

        if (stopwords != null) {
            if (textFileContent != null) {
                String text = String.join(" ", textFileContent);
                int words = WordCounter.countWordsFilteringOutStopwords(text, stopwords);
                System.out.println("Number of words: " + words);
                return;
            }
            System.out.println("Enter text: ");
            String text = scanner.nextLine();

            int words = WordCounter.countWordsFilteringOutStopwords(text, stopwords);
            System.out.println("Number of words: " + words);
        } else {
            System.err.println("Stopwords file not found.");
        }
    }

    public static void main(String[] args) {
        JavaApplication app = new JavaApplication();
        app.run(DEFAULT_STOPWORDS_FILE, args.length > 0
                ? args[0]
                : null);
    }
}
