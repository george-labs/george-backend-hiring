import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsService {

    public Set<String> getStopWords(Path stopWordsFile) {
        Set<String> stopWords;
        try (var lines = Files.lines(stopWordsFile)) {
            stopWords = lines.collect(Collectors.toUnmodifiableSet());
        } catch (IOException e) {
            throw new RuntimeException("Error reading stopwords.txt", e);
        }
        return stopWords;
    }

}
