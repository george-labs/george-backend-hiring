package input;

import file.FileHandler;

import java.io.InputStream;

public class InputReaderFactoryMock extends InputReaderFactory{
    private final InputStream inputStream;

    public InputReaderFactoryMock(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public InputReader createInputReader(String[] args) {
        String inputTxtFileName = getInputTxtFileName(args);
        if (inputTxtFileName != null) {
            return new FileInputReader(new FileHandler(), inputTxtFileName);
        }
        return new UserInputReader(inputStream);
    }
}
