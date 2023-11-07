import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

public class DictionaryService {
    private HashSet<String> stopwords = new HashSet<>();

    DictionaryService(String path){
        try {
            stopwords = new HashSet<String>(Files.readAllLines(Paths.get(path)));
            System.out.println(stopwords);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean contains(String word) {
        return stopwords.contains(word);
    }
}
