package bl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class StopWordsFileProvider implements StopWordsProvider {

    private final Set<String> stopWords;

    public StopWordsFileProvider() {
        this.stopWords = loadWords();
    }

    @Override
    public Set<String> getStopWords() {
        return stopWords;
    }

    private Set<String> loadWords() {
        Set<String> lines = new HashSet<>();
        try (FileReader reader = new FileReader("stopwords.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot read stopwords.txt file", e);
        }
        return lines;
    }
}
