import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

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

        try (InputStream inputStream =
                     JavaApplication.class.getClassLoader().getResourceAsStream("/stopwords.txt")) {


//            return Files.readAllLines(Path.of(
//                    "/Users/anton/IdeaProjects/george-backend-hiring/src/main/resources/stopwords.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
