package input;

import java.io.InputStream;

public class InputReaderFactoryMock extends InputReaderFactory{
    private final InputStream inputStream;

    public InputReaderFactoryMock(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public InputReader createInputReader(String[] args) {
        return new UserInputReader(inputStream);
    }
}
