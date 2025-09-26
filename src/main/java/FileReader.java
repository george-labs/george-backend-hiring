import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class FileReader {


    public List<String> getWordsFromFile(String fileName) throws Exception {

        try (InputStream inputStream = WordCount.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            return bufferedReader.lines()
                .flatMap(line -> Arrays.stream(TextUtil.trimAndSplitWord(line)))
                .toList();

        } catch (IOException io) {
            throw new Exception("Error happened during reading of the file");
        }
    }
}
