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
            words = Input.wordsFromFile(args[0]);
        } else {
            words = Input.wordsFromConsole();
        }
        System.out.println("Number of words:" + new WordCounter().countWords(words, stopwords));
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
