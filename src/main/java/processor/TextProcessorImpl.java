package processor;

import java.util.Arrays;
import java.util.Set;

import static utils.Constants.SPACE;
import static utils.Constants.WORD_PATTERN;

public class TextProcessorImpl implements TextProcessor {

    public long countWords(final String text, final Set<String> stopWords) {
        return Arrays.stream(text.split(SPACE))
                .filter(w -> w.matches(WORD_PATTERN))
                .filter(w -> !stopWords.contains(w))
                .count();
    }

}
