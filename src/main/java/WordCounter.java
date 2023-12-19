import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordCounter {

    private final Pattern allowedCharacters = Pattern.compile("[a-zA-Z]*");
    private List<String> ignoredWords;

    public WordCounter(List<String> ignoredWords) {
        this.ignoredWords = ignoredWords;
    }

    public long countWordsFromFile(String filename) {
        try {
            var file = new File(filename);
            if (file.exists()) {
                var lines = Files.readAllLines(Path.of(file.getPath()));
                return lines.stream()
                        .map(line -> line.split(" "))
                        .flatMap(Stream::of)
                        .map(this::countWords)
                        .count();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found");
        }
        throw new IllegalArgumentException("File not found");
    }

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }
        return Arrays.stream(input.split(" "))
                .filter(s -> !s.isEmpty())
                .filter(s -> allowedCharacters.matcher(s).matches())
                .filter(s -> !ignoredWords.contains(s))
                .count();
    }
}
