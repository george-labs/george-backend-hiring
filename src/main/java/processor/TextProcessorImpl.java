package processor;

import java.util.Arrays;

import static utils.Constants.SPACE;
import static utils.Constants.WORD_PATTERN;

public class TextProcessorImpl implements TextProcessor {

    public long countWords(final String text) {
        return Arrays.stream(text.split(SPACE)).filter(w -> w.matches(WORD_PATTERN)).count();
    }

}
