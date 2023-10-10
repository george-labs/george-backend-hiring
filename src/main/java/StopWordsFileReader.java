import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopWordsFileReader {
    public List<String> getWordsFromFile() {
        List<String> stopWords = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/stopwords.txt"));
            String line = reader.readLine();

            while (line != null) {
                stopWords.add(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }
}
