package processor;

import static utils.Constants.SPACE;

public class TextProcessorImpl implements TextProcessor {

    public int countWords(final String text) {
        return text.split(SPACE).length;
    }

}
