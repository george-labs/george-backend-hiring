package impl.writers.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class InputScannerUtil {

    public static String STOPWORDS_FILENAME_PATH = "src/main/resources/stopwords/stopwords.txt";

    private InputScannerUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    @NotNull
    public static List<String> readFile() {
        List<String> forbiddenWords = new ArrayList<>();

        try (var bufferedReader = new BufferedReader(new FileReader(STOPWORDS_FILENAME_PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                var listOfForbiddenWords = line.split("\\s");

                for (String forbiddenWord : listOfForbiddenWords) {
                    if (!forbiddenWord.isEmpty()) {
                        forbiddenWords.add(forbiddenWord);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("\nError during reading the file: " + e.getMessage());
        }
        return forbiddenWords;
    }

    @NotNull
    public static List<String> filterInputWords(final List<String> inputWords, final List<String> forbiddenWords) {
        return inputWords.stream()
                .filter(s ->  !forbiddenWords.contains(s))
                .toList();
    }
}
