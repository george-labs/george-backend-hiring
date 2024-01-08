import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileTextReader implements TextReader {

    private final String filename;

    public FileTextReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> read() throws IOException {
        return Files.readAllLines(Path.of(filename));
    }
}
