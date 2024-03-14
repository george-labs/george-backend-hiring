import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String readString(String path) {
        Path filePath = Path.of(path);

        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }
}
