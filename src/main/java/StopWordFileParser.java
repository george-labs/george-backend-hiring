import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordFileParser implements StopWordParser {

    private String path;

    public StopWordFileParser(String path) {
        this.path = path;
    }

    public Set<String> parseStopWords() {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
