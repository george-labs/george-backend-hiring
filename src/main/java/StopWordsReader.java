import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class StopWordsReader {

    private static final String PATH_TO_FILE = "src/main/resources/stopwords.txt";

    public Set<String> read() {
        try {
            return Set.copyOf(Files.readAllLines(Paths.get(PATH_TO_FILE)));
        } catch (IOException e) {
            System.out.println("We have troubles reading the file!");
            throw new RuntimeException(e);
        }
    }

}
