import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsUtil {

    private StopWordsUtil() {

    }

    private static final String STOP_WORDS_FILE_PATH = "src/main/resources/stopwords.txt";

    public static List<String> getStopWords() {
        try (Stream<String> lines = Files.lines(Paths.get(STOP_WORDS_FILE_PATH))) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("StopWords file is not valid!");
            return new ArrayList<>();
        }
    }
}
