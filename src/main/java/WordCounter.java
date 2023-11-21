import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    private final String delimiter;
    private final Pattern pattern;
    private final StopWordList stopWordList;

    public static String SPACE_DELIMITER = " ";
    public static String ALPHABETIC_WORD_PATTERN = "[A-Za-z]+";

    public WordCounter() {
        this(SPACE_DELIMITER, ALPHABETIC_WORD_PATTERN, new StopWordList(List.of()));
    }

    public WordCounter(String delimiter, String wordPattern, StopWordList stopWordList) {
        this.delimiter = delimiter;
        this.pattern = Pattern.compile(wordPattern);
        this.stopWordList = stopWordList;
    }

    public WordCounts countWords(String input) {
        if (input == null) {
            return new WordCounts(0, 0);
        }

        String[] candidateWords = input
                .replaceAll("\\r\\n|\\r|\\n", " ") // replace line breaks with spaces
                .split(this.delimiter);

        Stream<String> filteredStream =  Arrays.stream(candidateWords)
                .filter(word -> this.pattern.matcher(word).matches())
                .filter(word -> !this.stopWordList.isStopWord(word));

        return new WordCounts(filteredStream.count(), -1); // TODO
    }
}