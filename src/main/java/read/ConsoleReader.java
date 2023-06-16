package read;

import exception.IterationException;

import java.util.stream.Stream;

public class ConsoleReader extends Reader {

    private String sentence;

    public ConsoleReader(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public Stream<String> read() throws IterationException {
        validateSentence(this.sentence);
        return Stream.of(this.sentence);
    }
}
