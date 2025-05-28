import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class TextFileReadingService {

    public String readFile(String fileName) {
        String text = "";
        try (var lines = Files.lines(Path.of(fileName))) {
            text = lines.collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
        return text;
    }
}
