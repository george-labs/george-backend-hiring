import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StopWordsReader {

//    private final static String FILENAME = "stopWords.txt";

    public List<String> getWordsFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return getWords(inputStream);
        }
    }

    private List<String> getWords(InputStream is) {
        List<String> words = new ArrayList<>();

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
