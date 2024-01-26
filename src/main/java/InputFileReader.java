import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputFileReader {
    public String readFromFile(String path) throws IOException {
        var wordsInFle = Files.readString(Path.of(path));
        return wordsInFle;
    }

    public List<String> getWordsExceptStopWords() throws IOException {
                var url = this.getClass().getClassLoader().getResource("stopwords.txt");
                assert url != null;
                return Files.readAllLines(Path.of(url.getPath()));
    }
}
