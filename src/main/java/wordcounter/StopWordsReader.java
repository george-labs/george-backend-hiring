package wordcounter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class StopWordsReader {

    private final String stopWordFileName;

    public StopWordsReader(String stopWordFileName) {
        this.stopWordFileName = stopWordFileName;
    }

    public List<String> getStopWords() {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resource = classLoader.getResourceAsStream(stopWordFileName);

        if (resource == null) {
            throw new RuntimeException("File 'stopwords.txt' not found");
        }

        return new BufferedReader(new InputStreamReader(resource)).lines().toList();
    }

}
