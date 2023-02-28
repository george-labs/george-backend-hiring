package wordcount.inputreader;

import wordcount.CriticalAppException;
import wordcount.InputReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class InputFileReader implements InputReader {

    private final String filename;

    public InputFileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public String readInput() {
        try (InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader()
                .getResourceAsStream(filename))) {
            return new String(inputStream.readAllBytes())
                    .replace(System.lineSeparator(), " ")
                    .trim();
        } catch (IOException e) {
            throw new CriticalAppException("Failed to read the file with input");
        }
    }
}
