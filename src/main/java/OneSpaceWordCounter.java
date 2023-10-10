import java.util.Arrays;
import java.util.List;

public class OneSpaceWordCounter implements WordCounter{

    WordValidator wordValidator;
    StopWordsFileReader fileReader;

    public OneSpaceWordCounter(WordValidator wordValidator, StopWordsFileReader fileReader) {
        this.wordValidator = wordValidator;
        this.fileReader = fileReader;
    }

    @Override
    public long countWords(String line) {
        List<String> stopWords = fileReader.getWordsFromFile();
        return Arrays.stream(line.split(" "))
                .filter(word -> wordValidator.isValidWord(word))
                .filter(word -> wordValidator.isOnStopList(stopWords, word))
                .count();
    }
}
