package com.example;

import com.example.utils.FileHelper;
import com.example.utils.WordCounter;

import java.io.File;
import java.nio.file.Files;
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
    private String stopwordsFileName;
    private String textFileName;

    public JavaApplication(String stopwordsFileName, String textFileName) {
        this.stopwordsFileName = stopwordsFileName;
        this.textFileName = textFileName;
    }

    public void run(String stopwordsFileName, String textFileName) {
        Scanner scanner = new Scanner(System.in);
        List<String> stopwords = FileHelper.getFileLines(stopwordsFileName);

        if (stopwords != null) {
            System.out.println("Enter text: ");
            String text = scanner.nextLine();

            int words = WordCounter.countWordsFilteringOutStopwords(text, stopwords);
            System.out.println("Number of words: " + words);
        } else {
            System.err.println("Stopwords file not found.");
        }
    }

    public static void main(String[] args) {
        JavaApplication app = new JavaApplication(
                DEFAULT_STOPWORDS_FILE,
                args.length > 0
                        ? args[0]
                        : null);
        app.run(app.stopwordsFileName, app.textFileName);
    }
}
