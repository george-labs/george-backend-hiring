import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordUtil {

    private static final String VALID_PATTERN = "[a-zA-Z]+";
    private static final String SEPARATOR = " ";

    private WordUtil() {

    }

    public static List<String> readFile(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        Stream<String> stringStream = Files.lines(Path.of(filePath));
        List<String[]> lines;
        try (stringStream) {
            lines = stringStream
                    .map(line -> line.split(SEPARATOR))
                    .collect(Collectors.toList());
        }
        for (String[] line : lines) {
            words.addAll(Arrays.asList(line));
        }
        return words;
    }

    public static long getWordsCount(String text) {
        String[] splitText = text.split(SEPARATOR);
        return Arrays
                .stream(splitText)
                .filter(word -> word.matches(VALID_PATTERN))
                .filter(word -> !StopWordsUtil.getStopWords().contains(word))
                .count();
    }

    public static long getWordsCount(List<String> textElements) {
        return textElements.stream()
                .filter(word -> word.matches(VALID_PATTERN))
                .filter(word -> !StopWordsUtil.getStopWords().contains(word))
                .count();
    }
}
