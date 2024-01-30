package application.text;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;

public class Text {
    private final static String SPACE = " ";
    private final static String ALPHABETIC_REGEX = "[a-zA-Z]+";

    private final String sentenceValue;


    public Text(final String sentenceValue) {
        this.sentenceValue = sentenceValue;
    }

    public Long calculateWordsInSentence() {
        return ofNullable(sentenceValue)
                .map(sentence -> stream(sentence.split(SPACE))
                        .filter(word -> word.matches(ALPHABETIC_REGEX))
                        .count()
                )
                .orElse(0L);
    }
}
