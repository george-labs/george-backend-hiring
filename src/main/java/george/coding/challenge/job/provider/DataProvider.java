package george.coding.challenge.job.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class DataProvider {

    private final List<String> words;

    public DataProvider(String filename) throws IOException {
        this.words = readWords(createPath(filename));
    }

    public List<String> words() {
        return words;
    }

    private List<String> readWords(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        }
    }

    private Path createPath(String fileName) throws FileNotFoundException {
        try {
            return Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI());
        } catch (Exception e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

}
