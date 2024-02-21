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
            System.out.println("Enter text: ");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();

            StopWordsChecker stopWordsChecker = new StopWordsCheckerImpl("src/main/resources/stopwords.txt");
            WordsCounter counter = new WordCounterImpl(stopWordsChecker);

            System.out.println("Number of words: " + counter.countWords(text));


//            Path path = Paths.get("src/main/resources/stopwords.txt");

//            List<String> stopWords = Files.readAllLines(path);

//            System.out.println(String.join(",", stopWords));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
