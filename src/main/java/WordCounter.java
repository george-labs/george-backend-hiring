import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {

    private final FileLoader fileLoader;

    public WordCounter(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    public long countNotBlackListedWords(String input) {
        var blackListWords = fileLoader.loadFile("stopwords.txt");
        var pattern = Pattern.compile("[a-zA-Z]+");

        return Arrays.stream(splitInput(input))
                .filter(item -> pattern.matcher(item).matches() && !blackListWords.contains(item))
                .count();
    }


    private String[] splitInput(String inputStr) {
        return inputStr.split("\\s+");
    }
}
