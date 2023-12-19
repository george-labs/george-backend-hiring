import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class IgnoredWords {

    public List<String> getIgnoredWords(String filename) {
        if (filename != null && filename.isEmpty()) {
            return List.of();
        }

        try {
            var file = this.getClass().getClassLoader().getResource(filename);
            if (file != null) {
                return Files.readAllLines(Path.of(file.getPath()));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found");
        }
        throw new IllegalArgumentException("File not found");
    }
}
