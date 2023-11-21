import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    private final Tokenizer tokenizer;
    private final StopWordList stopWordList;

    public WordCounter() {
        this(new Tokenizer(), new StopWordList(List.of()));
    }

    public WordCounter(Tokenizer tokenizer, StopWordList stopWordList) {
        this.tokenizer = tokenizer;
        this.stopWordList = stopWordList;
    }

    public Statistics countWords(String input) {
        if (input == null) {
            return new Statistics(0, 0, 0);
        }

        Stream<String> tokens =  tokenizer.tokenize(input)
                .filter(word -> !this.stopWordList.isStopWord(word));

        return generateStatistics(tokens);
    }

    private Statistics generateStatistics(Stream<String> tokens) {
        List<String> words = tokens.collect(Collectors.toList());
        Set<String> uniqueWordSet = new HashSet<>(words);
        double averageWordLength = words.stream().mapToDouble(String::length).average().orElse(0);

        return new Statistics(words.size(), uniqueWordSet.size(), averageWordLength);
    }
}