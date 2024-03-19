package interview.business;

import interview.output.WordCountOutput;
import interview.reader.InputReader;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : Xenofon Zinoviou
 */
public class WordCounter {

    private static final String VALID_CHARS = "[a-zA-Z]+([,.?;!])?";
    private static final String REGEX_SPLITTER = "\\s";

    private final InputReader inputReader;

    public WordCounter(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public WordCountOutput processInput() {

        final String textInput = inputReader.readInput();

        final long totalWords = Arrays.stream(textInput.split(REGEX_SPLITTER))
                .filter(isWordValid())
                .count();

        return WordCountOutput.of(totalWords);
    }


    private Predicate<String> isWordValid() {
        return (word) -> {
            Pattern pattern = Pattern.compile(VALID_CHARS);
            Matcher matcher = pattern.matcher(word);
            return matcher.matches();
        };
    }
}
