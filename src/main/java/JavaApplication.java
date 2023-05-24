import kotlin.text.Regex;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaApplication {
    private final static String fileUrl = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileUrl)))) {
            final List<String> stopWords = reader.lines().collect(Collectors.toList());
            final WordCounter wordCounter = new WordCounter(new Regex("[A-Za-z]+"), stopWords);
            final Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text:");
            String line = scanner.nextLine();
            final Integer numberOfWords = wordCounter.countWordsInLine(line);
            System.out.printf("Number of words: %d%n",numberOfWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
