package read;

import exception.IterationException;

import java.io.IOException;
import java.util.stream.Stream;

public abstract class Reader {

    public abstract Stream<String> read() throws IOException;

    private void validationSentence(String sentence) throws IterationException {
        if (sentence.isBlank()) {
            throw new IterationException("The entire sentence is not correct");
        }
    }

}
