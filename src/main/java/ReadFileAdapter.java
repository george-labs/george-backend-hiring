import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReadFileAdapter {

    public static String loadTextFromFile(String filename) {
        ClassLoader classLoader = ReadFileAdapter.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        try {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public static Set<String> getStopWords() {
        ClassLoader classLoader = ReadFileAdapter.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("stopwords.txt");
        try {
            String text = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return new HashSet<>(Arrays.asList(text.split("\\s+")));
        } catch (Exception e) {
            return new HashSet<>();
        }
    }

}
