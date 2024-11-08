import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInputWordsProvider implements WordsProvider {

    private final String fileName;

    public FileInputWordsProvider(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> provideWords() {
        try {
            return Files.readAllLines(Paths.get(this.fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
