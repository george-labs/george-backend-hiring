import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private final FileLoader fileLoader;

    public WordCounter(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    public long countNotBlackListedWords(List<String> input) {
        var blackListWords = fileLoader.loadFile("stopwords.txt");
        var pattern = Pattern.compile("[a-zA-Z]+");

        return input.stream()
                .filter(item -> pattern.matcher(item).matches() && !blackListWords.contains(item))
                .count();
    }

    public long countNotBlackListedWords(String input) {
        var blackListWords = fileLoader.loadFile("stopwords.txt");
        var pattern = Pattern.compile("[a-zA-Z]+");

        return Arrays.stream(WordUtils.splitInput(input))
                .filter(item -> pattern.matcher(item).matches() && !blackListWords.contains(item))
                .count();
    }


}
