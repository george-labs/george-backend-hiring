import exception.WordCounterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public List<String> readWordsFromFile(String path) {
        List<String> words;

        Path p = Paths.get(path);

        try {
            words = Files.readAllLines(p);
        } catch (IOException e) {
            throw new WordCounterException("File could not be found at: " + path, e);
        }
        return words;
    }

    public String readWordsFromFileAsString(String fileName) {
        List<String> wordsAsList = this.readWordsFromFile(fileName);

        return String.join(" ", wordsAsList);
    }
}
