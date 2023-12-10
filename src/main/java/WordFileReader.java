import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class WordFileReader {
    private static final String RESOURCES_PATH = "src/main/resources/";

    private final static String FILENAME_REGEX = "^[a-zA-Z0-9_-]+.txt$";

    public static List<String> loadFileIntoList(String filename) throws IOException {
        Path filePath = Paths.get(RESOURCES_PATH + filename);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("File Does not exist");
        }
        return Files.readAllLines(filePath);
    }

    public static boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return false;
        }
        return Pattern.matches(FILENAME_REGEX, fileName);
    }
}
