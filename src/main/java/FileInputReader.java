import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInputReader implements InputReader {

    @Override
    public String readInput(String fileName) {
        try {
            final Path path = Paths.get(fileName);
            return Files.readString(path);
        } catch (IOException e) {
            // should be RuntimeException extension to prevent catching IOException
            throw new RuntimeException("File " + fileName + " not found");
        }
    }
}
