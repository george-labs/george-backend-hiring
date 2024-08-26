import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StopWordsLoader {

    public static List<String> loadStopWords(String filename) {
        return loadStopWords(filename);
    }

    public static List<String> loadStopWords() {
        var stopWords = new ArrayList<String>();

        try (
                var inputStream = StopWordsLoader.class.getClassLoader().getResourceAsStream("stopwords.txt");
                var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return stopWords;
    }
}
