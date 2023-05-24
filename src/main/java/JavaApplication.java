import kotlin.text.Regex;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaApplication {
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String FILE_PATH = RESOURCES_PATH+"stopwords.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH)))) {
            final List<String> stopWords = reader.lines().collect(Collectors.toList());
            final Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            if (!fileName.isBlank()) {
                countWordsFromFile(fileName, stopWords);
            } else {
                countWordsFromSystemIN(scanner, stopWords);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void countWordsFromSystemIN(Scanner scanner, List<String> stopWords) {
        System.out.print("Enter text:");
        String line = scanner.nextLine();
        final WordCounter wordCounter = new WordCounter(new Regex("[A-Za-z]+"), stopWords, line);
        final Integer numberOfWords = wordCounter.countWords();
        System.out.printf("Number of words: %d%n", numberOfWords);
    }

    private static void countWordsFromFile(String fileName, List<String> stopWords) throws FileNotFoundException {

    }
}
