package com.erste;

import com.erste.filter.StopWordFilter;
import com.erste.service.FilteringWordCounter;
import com.erste.service.WordCounter;
import com.erste.util.ResourceFileReader;

import java.io.InputStream;
import java.util.Scanner;

public class JavaApplication {

    public static final String RESULT_MESSAGE_FORMAT = "Number of words: ";
    private final WordCounter wordCounter;
    private final ResourceFileReader reader;

    public JavaApplication(String resourceFolderPath) {
        reader = new ResourceFileReader(resourceFolderPath);
        StopWordFilter stopWordFilter = new StopWordFilter(reader);

        wordCounter = new FilteringWordCounter(stopWordFilter);
    }

    public static void main(String[] args) {
        String resourceFolderPath = "src/main/resources/";

        String result = new JavaApplication(resourceFolderPath).run(args, System.in);
        System.out.println(result);
    }

    public String run(String[] args, InputStream userInput) {
        String filename = null;
        if (args.length > 0) {
            filename = args[0];
        }

        System.out.println("File name: " + filename);
        if (filename != null && !filename.isBlank()) {
            int result = wordCounter.countWords(reader.readFileToString(filename));
            return printResult(result);
        } else {
            try (Scanner scanner = new Scanner(userInput)) {
                System.out.println("Please enter text to analyze: ");
                if (scanner.hasNextLine()) {
                    String textToAnalyze = scanner.nextLine();
                    int countWords = wordCounter.countWords(textToAnalyze);
                    return printResult(countWords);
                }
            }
        }
        return "No words to analyze";
    }

    private static String printResult(int countWords) {
        return RESULT_MESSAGE_FORMAT + countWords;
    }

}
