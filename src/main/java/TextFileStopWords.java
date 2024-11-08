import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFileStopWords implements StopWordsProvider {

    private static final String STOP_WORDS_FILE = "stopwords.txt";

    @Override
    public List<String> provideStopWords() {

        try {
            // Get the file from the resources folder using the classloader
            var resourcePath = TextFileStopWords.class.getResource(STOP_WORDS_FILE);

            if (resourcePath == null) {
                throw new IOException("File not found in resources: " + STOP_WORDS_FILE);
            }

            return Files.readAllLines(Paths.get(resourcePath.toURI()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
