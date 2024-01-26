import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputFileReader {
    public String readFromFile(String path) throws IOException {
        var wordsInFle = Files.readString(Path.of(path));
        return wordsInFle;
    }
}
