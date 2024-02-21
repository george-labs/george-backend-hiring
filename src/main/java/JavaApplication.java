import sourceprovider.ConsoleTextProvider;
import sourceprovider.FileTextProvider;
import sourceprovider.TextProvider;
import textprocessor.StopWordsChecker;
import textprocessor.StopWordsCheckerImpl;
import textprocessor.WordCounterImpl;
import textprocessor.WordsCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaApplication {
    public static void main(String[] args) {
        try {
            String fileName = args.length > 0 ? args[0] : "";
            TextProvider textProvider;
            if (!fileName.isBlank()) {
                textProvider = new FileTextProvider(fileName);
            } else {
                textProvider = new ConsoleTextProvider();
            }

            StopWordsChecker stopWordsChecker = new StopWordsCheckerImpl("src/main/resources/stopwords.txt");
            WordsCounter counter = new WordCounterImpl(stopWordsChecker);

            System.out.println("Number of words: " + counter.countWords(textProvider.provide()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
