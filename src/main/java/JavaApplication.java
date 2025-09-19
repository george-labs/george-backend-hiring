import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Assumption
 * one-line input only
 *
 * input handling not tested
 */
public class JavaApplication {

    public static void main(String... args) {
        List<String> stopwords = readStopwords();
        String words;
        if (args.length > 0) {
            words = wordsFromFile(args[0]);
        } else {
            words = wordsFromConsole();
        }
        System.out.println("Number of words:" + new WordCounter().countWords(words, stopwords));
    }

    private static String wordsFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String wordsFromConsole() {
        // "wor3d word" = per regex in description will be split to wor, d, word

        System.out.println("Enter text:");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static List<String> readStopwords() {
        try {
            return Files.readAllLines(Path.of(
                    "src/main/resources/stopwords.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
