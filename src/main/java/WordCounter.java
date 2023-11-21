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

    public WordCounts countWords(String input) {
        if (input == null) {
            return new WordCounts(0, 0);
        }

        Stream<String> filteredStream =  tokenizer.tokenize(input)
                .filter(word -> !this.stopWordList.isStopWord(word));

        List<String> words = filteredStream.collect(Collectors.toList());
        Set<String> uniqueWordSet = new HashSet<>(words);

        return new WordCounts(words.size(), uniqueWordSet.size());
    }
}