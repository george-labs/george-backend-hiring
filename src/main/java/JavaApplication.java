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
        // "wor3d word" = per regex in description will be split to wor, d, word

        System.out.println("Enter text:");
        Scanner scan = new Scanner(System.in);

        List<String> stopwords = readStopwords();
        System.out.println("Number of words:" + new WordCounter().countWords(scan.nextLine(), stopwords));
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
