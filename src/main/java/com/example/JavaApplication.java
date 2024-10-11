package com.example;

import com.example.components.ConsoleTextProvider;
import com.example.components.FileTextProvider;
import com.example.components.ITextProvider;
import com.example.utils.FileHelper;
import com.example.utils.WordCounter;

import java.util.List;

/**
 *
 * - wordcount
 * - stopwords.txt
 * - text.txt
 */

public class JavaApplication {
    private static final String DEFAULT_STOPWORDS_FILE = "stopwords.txt";

    public void run(String stopwordsFileName, String textFileName) {
        List<String> stopwords = FileHelper.getFileLines(stopwordsFileName);

        ITextProvider textProvider = textFileName != null
                ? new FileTextProvider(textFileName)
                : new ConsoleTextProvider();

        if (stopwords != null) {
            String text = textProvider.getInputText();
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
