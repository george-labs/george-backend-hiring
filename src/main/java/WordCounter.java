import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private final String splitRegex = "[.\\s]";
    private final Pattern allowedCharacters = Pattern.compile("[a-zA-Z-]*");
    private final List<String> ignoredWords;
    private final boolean createIndex;

    public WordCounter(List<String> ignoredWords, boolean createIndex) {
        this.ignoredWords = ignoredWords;
        this.createIndex = createIndex;
    }

    public WordCount countWordsFromFile(String filename) {
        try {
            var file = new File(filename);
            if (file.exists()) {
                var lines = Files.readAllLines(Path.of(file.getPath()));
                var splitedLines = lines.stream()
                        .map(line -> line.split(splitRegex))
                        .flatMap(Stream::of)
                        .collect(Collectors.toList());
                return countWords(splitedLines);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found");
        }
        throw new IllegalArgumentException("File not found");
    }

    public WordCount countWords(String input) {
        if (input == null) {
            return new WordCount(0, 0, 0, Set.of());
        }
        return countWords(Arrays.asList(input.split(splitRegex)));
    }

    private WordCount countWords(List<String> lines) {
        var wordsCountMap = lines.stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> allowedCharacters.matcher(s).matches())
                .filter(s -> !ignoredWords.contains(s))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        var wordsCount = wordsCountMap.values()
                .stream()
                .mapToLong(value -> value)
                .sum();

        var wordsLengthTotal = 0L;
        for (Map.Entry<String, Long> entry : wordsCountMap.entrySet()) {
            wordsLengthTotal += entry.getKey().length() * entry.getValue();
        }

        var uniqueWords = wordsCountMap.values()
                .stream()
                .filter(n -> n == 1)
                .count();

        var averageWordsLength = wordsCount == 0 ? 0 : new BigDecimal((double) wordsLengthTotal /wordsCount).round(
                new MathContext(3)).doubleValue();

        return new WordCount(wordsCount, uniqueWords, averageWordsLength, createIndex ? wordsCountMap.keySet() : Set.of());
    }
}
