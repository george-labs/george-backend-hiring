package impl.writers.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ReadFileUtil {

    public static String STOPWORDS_FILENAME_PATH = "src/main/resources/stopwords/stopwords.txt";

    private ReadFileUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    @NotNull
    public static List<String> readFile() {
        return readFile(STOPWORDS_FILENAME_PATH);
    }

    @NotNull
    public static List<String> readFile(final String filename) {
        List<String> words = new ArrayList<>();

        try (var bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                var wordsList = line.split("\\s");

                for (String word : wordsList) {
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("\nError during reading the file: " + e.getMessage());
        }
        return words;
    }
}
