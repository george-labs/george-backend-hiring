import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStopWordsReader implements StopWordsReader {

    @Override
    public List<String> readStopWords() {
        InputStream inputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
        if (inputStream == null) {
            throw new RuntimeException("stopwords.txt not found in resources");
        }
        Scanner in = new Scanner(new InputStreamReader(inputStream));
        List<String> stopWords = new ArrayList<>();
        while (in.hasNextLine()) {
            stopWords.add(in.nextLine());
        }
        in.close();

        return stopWords;
    }
}
