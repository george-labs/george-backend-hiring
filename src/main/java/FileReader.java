import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {


    public List<String> getWordsFromFile(String fileName) throws Exception {

        try (InputStream inputStream = WordCount.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            return bufferedReader.lines()
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        } catch (IOException io) {
            throw new Exception("Error happened during reading of the file");
        }
    }
}
