import java.util.Arrays;

public class OneSpaceWordCounter implements WordCounter{

    WordValidator wordValidator;

    public OneSpaceWordCounter(WordValidator wordValidator) {
        this.wordValidator = wordValidator;
    }

    @Override
    public long countWords(String line) {
        return Arrays.stream(line.split(" "))
                .filter(word -> wordValidator.isValidWord(word))
                .count();
    }
}
