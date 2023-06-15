import exception.WordCounterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private final String path;

    public FileReader(String path) {
        this.path = path;
    }

    public List<String> readWordsFromFile() {
        List<String> forbiddenWords;

        Path path = Paths.get(this.path);

        try {
            forbiddenWords = Files.readAllLines(path);
        } catch (IOException e) {
            throw new WordCounterException("File could not be found at: " + this.path, e);
        }
        return forbiddenWords;
    }
}
