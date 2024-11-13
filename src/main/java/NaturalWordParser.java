import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NaturalWordParser implements WordParser{

    private static final String DELIMITER = " ";
    private static final String WORD_DEFINITION = "[a-zA-Z]+";

    @Override
    public int countWords(String input) {

        if (input == null){
            throw new IllegalStateException("Input string must not be null");
        }

        String[] possibleWords = input.split(DELIMITER);


        return (int) Arrays.stream(possibleWords)
                .filter(this::validateWord)
                .count();
    }

    private boolean validateWord(String word){
        return word.matches(WORD_DEFINITION);
    }
}
