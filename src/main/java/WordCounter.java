import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private final String splitRegex = "[.\\s]";
    private final Pattern allowedCharacters = Pattern.compile("[a-zA-Z-]*");
    private final List<String> ignoredWords;
    private final ParamParser paramParser;
    private final List<String> dictionary;
    private final InputScanner inputScanner;
    private int unkonwnWords;

    public WordCounter(List<String> ignoredWords, ParamParser paramParser, InputScanner inputScanner) {
        this.ignoredWords = ignoredWords;
        this.paramParser = paramParser;
        this.inputScanner = inputScanner;

        if (paramParser.shouldCreateIndex() && paramParser.getDictionaryFileName().isPresent()) {
            var file = new File(paramParser.getDictionaryFileName().get());
            try {
                dictionary = Files.readAllLines(Path.of(file.getPath()));
            } catch (IOException e) {
                throw new IllegalArgumentException("Could not create dictionary");
            }
        } else {
            dictionary = List.of();
        }
    }

    public void countWords() {
        if (paramParser.getFileName().isEmpty()) {
            System.out.print("Enter text: ");
            var line = inputScanner.nextLine();
            printResult(this.countWords(line));
        } else {
            printResult(this.countWordsFromFile(paramParser.getFileName().get()));
        }
    }

    private void printResult(WordCount wordCount) {
        System.out.print(
                "Number of words: " + wordCount.getWordCount() + ", unique: " + wordCount.getUniqueWords() + ", average word length: " + wordCount.getAverageWordLength() + " characters");
        if (!wordCount.getCountedWords().isEmpty()) {
            if (dictionary.isEmpty()) {
                System.out.println("\nIndex:");
            } else {
                System.out.println("\nIndex (unknown: " + unkonwnWords + "):");
            }
            wordCount.getCountedWords().forEach(System.out::println);
        }
    }

    private WordCount countWordsFromFile(String filename) {
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

    private WordCount countWords(String input) {
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

        var averageWordsLength = wordsCount == 0 ? 0 : new BigDecimal((double) wordsLengthTotal / wordsCount).round(
                new MathContext(3)).doubleValue();

        return new WordCount(wordsCount, uniqueWords, averageWordsLength,
                paramParser.shouldCreateIndex() ? wordsCountMap.keySet() : Set.of());
    }
}
