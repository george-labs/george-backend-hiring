package wordcount.inputreader;

import wordcount.CriticalAppException;
import wordcount.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class InputFileReader implements InputReader {

    private final String filename;

    public InputFileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public String readInput() {
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(filename)).toURI());
            return String.join(" ", Files.readAllLines(path));
        } catch (URISyntaxException | IOException e) {
            throw new CriticalAppException("Failed to read the file with input");
        }
    }
}
