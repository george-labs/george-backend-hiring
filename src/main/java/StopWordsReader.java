import exceptions.WordCountException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;

public class StopWordsReader {

    private String pathToFile;
    private static final String PATH_TO_FILE = "src/main/resources/stopwords.txt";

    public StopWordsReader() {
    }

    public StopWordsReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Set<String> read() {
        try {
            return Set.copyOf(Files.readAllLines(resolvePath()));
        } catch (IOException e) {
            String errorMessage = "We have troubles reading the file!";
            System.out.println(errorMessage);
            throw new WordCountException(errorMessage);
        }
    }

    @NotNull
    private Path resolvePath() {
        return Paths.get(Objects.isNull(pathToFile) ? PATH_TO_FILE : pathToFile);
    }
}
