package george.coding.challenge.job.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class DataProvider {

    private final List<String> words;

    public DataProvider(String filename) throws IOException {
        Path path = createPath(filename)
                .orElseThrow(() -> new FileNotFoundException("Resource not found: " + filename));
        this.words = readWords(path);
    }

    public List<String> words() {
        return words;
    }

    private List<String> readWords(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        }
    }

    private Optional<Path> createPath(String fileName) {
        try {
            return Optional.of(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
