import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class FileReader {


    public Set<String> getStopWords() throws Exception {

        try (InputStream inputStream = WordCount.class.getClassLoader().getResourceAsStream("stopwords.txt");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            return bufferedReader.lines()
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        } catch (IOException io) {
            throw new Exception("Error happened during reading of the file");
        }
    }
}
