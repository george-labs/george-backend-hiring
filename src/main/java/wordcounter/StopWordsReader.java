package wordcounter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsReader {

    private final Set<String> stopWords;

    public StopWordsReader(String stopWordFileName) {
        this.stopWords = readStopWords(stopWordFileName);
    }

    public Set<String> getStopWords() {
        return stopWords;
    }

    private Set<String> readStopWords(String stopWordFileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resource = classLoader.getResourceAsStream(stopWordFileName);

        if (resource == null) {
            throw new RuntimeException("File 'stopwords.txt' not found");
        }

        return new BufferedReader(new InputStreamReader(resource))
                .lines()
                .collect(Collectors.toSet());
    }

}
