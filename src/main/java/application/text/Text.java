package application.text;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;

public class Text {
    private final static String SPACE = " ";
    private final static String ALPHABETIC_REGEX = "[a-zA-Z]+";

    private final String sentenceValue;

    public Text(final String sentenceValue) {
        this.sentenceValue = sentenceValue;
    }

    public Long calculateWordsInText(final List<String> stopWords) {
        return ofNullable(sentenceValue)
                .map(sentence -> stream(sentence.split(SPACE))
                        .filter(word -> !stopWords.contains(word) && word.matches(ALPHABETIC_REGEX))
                        .count()
                )
                .orElse(0L);
    }
}
