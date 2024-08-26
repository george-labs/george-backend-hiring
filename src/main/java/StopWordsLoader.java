import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StopWordsLoader {

    public static List<String> loadStopWords() throws IOException {
        return loadStopWords("stopwords.txt");
    }

    public static List<String> loadStopWords(String filename) throws IOException {
        var stopWords = new ArrayList<String>();
        var inputStream = StopWordsLoader.class.getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            throw new IOException(String.format("File '%s' not found", filename));
        }

        var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stopWords.add(line);
        }

        inputStream.close();
        bufferedReader.close();

        return stopWords;
    }
}
