import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordFileReader {
    private final static String FILENAME_REGEX = "^[a-zA-Z0-9_-]+.txt$";

    public static List<String> loadFileIntoList(String filename) throws IOException {
        List<String> fileItems = new ArrayList<>();
        InputStream inputStream = WordFileReader.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            while (line != null) {
                fileItems.add(line);
                line = reader.readLine();
            }
            reader.close();
            return fileItems;
        } else {
            throw new FileNotFoundException("File Does not exist");
        }
    }

    public static boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return false;
        }
        return Pattern.matches(FILENAME_REGEX, fileName);
    }
}
