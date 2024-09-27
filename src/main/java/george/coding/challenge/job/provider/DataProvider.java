package george.coding.challenge.job.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProvider {

    private final Set<String> words;

    public DataProvider(String filename) throws IOException {
        this.words = readWords(createPath(filename));
    }

    public Set<String> getExcludedWords() {
        return words;
    }

    private Set<String> readWords(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toSet());
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
