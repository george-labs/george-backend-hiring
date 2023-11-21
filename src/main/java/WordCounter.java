import java.util.*;
import java.util.stream.Collectors;

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
            return Statistics.of();
        }

        List<String> tokens =  tokenizer.tokenize(input)
                .filter(word -> !this.stopWordList.isStopWord(word))
                .collect(Collectors.toList());

        return Statistics.of(tokens);
    }
}