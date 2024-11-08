import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileInputWordsProvider implements WordsProvider {

    private final String fileName;

    public FileInputWordsProvider(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> provideWords() {
        try {
            return Files.lines(Paths.get(fileName))
                    .flatMap(line -> splitWords(line).stream())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
