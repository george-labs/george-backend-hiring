package processor;

import java.util.regex.Pattern;

import static utils.Constants.WORD_PATTERN;

public class TextProcessorImpl implements TextProcessor {

    private final Pattern pattern;

    public TextProcessorImpl() {
        this.pattern = Pattern.compile(WORD_PATTERN);
    }

    public long countWords(final String text) {
        return pattern.matcher(text).results().count();
    }

}
