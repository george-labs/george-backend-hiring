package wordcount.stopwordsreader;

import wordcount.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class StopWordsReader implements FileReader {

    @Override
    public List<String> raed() {
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("stopwords.txt")).toURI());
            return Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            throw new CriticalAppException("Failed to read the file with stop words");
        }
    }
}
