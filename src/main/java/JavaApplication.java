import kotlin.text.Regex;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaApplication {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Constraints.FILE_PATH)))) {
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
        final Counter wordCounter = new WordCounter(new Regex(Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING),
                stopWords,
                line,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        wordCounter.display();
    }

    private static void countWordsFromFile(String fileName, List<String> stopWords) throws FileNotFoundException {
        final Counter fileCounter = new WordCounterFileAdapter(fileName,
                stopWords,
                Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        fileCounter.display();
    }
}
