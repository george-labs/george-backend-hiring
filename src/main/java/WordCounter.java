import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordCounter {

    private final FileLoader fileLoader;

    public WordCounter(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    public long countNotBlackListedWords(List<String> input, boolean distinct) {
        var blackListWords = fileLoader.loadFile("stopwords.txt");
        var pattern = Pattern.compile("[a-zA-Z.-]+");

        Stream<String> str = input.stream()
                .filter(item -> pattern.matcher(item).matches() && !blackListWords.contains(item));
        if (distinct) {
            return str.distinct().count();
        } else {
            return str.count();
        }
    }

    public long countNotBlackListedWords(String input, boolean isDistinct) {
        String[] splitedInput = WordUtils.splitInput(input);
        return countNotBlackListedWords(Arrays.stream(splitedInput).toList(), isDistinct);
    }


}
