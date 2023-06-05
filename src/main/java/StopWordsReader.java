import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StopWordsReader {

    private final static String FILENAME = "stopWords.txt";

    public List<String> getStopWordsFromResources() {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(FILENAME);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + FILENAME);
        } else {
            return getStopWords(inputStream);
        }
    }

    private List<String> getStopWords(InputStream is) {
        List<String> stopWords = new ArrayList<>();

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader);) {

            String line;
            while ((line = reader.readLine()) != null) {
                stopWords.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stopWords;
    }
}
