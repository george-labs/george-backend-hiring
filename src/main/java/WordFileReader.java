import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordFileReader {
    private static final String RESOURCES_PATH = "src/main/resources/";

    public static List<String> loadFileIntoList(String filename) throws IOException {
        Path filePath = Paths.get(RESOURCES_PATH + filename);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("File Does not exist");
        }
        return Files.readAllLines(filePath);
    }
}
