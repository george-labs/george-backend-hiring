import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounterFactory {


    private WordCounterFactory() {
    }

    public static WordCounter createWithDefaultStopWords(List<String> text) {
        List<String> stopWords = getStopWords();
        return new WordCounter(text, stopWords);
    }


    private static List<String> getStopWords() {
        URL resource = JavaApplication.class.getClassLoader().getResource("stopwords.txt");
        try {
            if (resource != null) {
                return Files.readAllLines(Path.of(resource.toURI())).stream().map(String::trim).collect(Collectors.toList());
            } else {
                throw new IllegalStateException("The stopwords resource was not found.");
            }
        } catch (URISyntaxException | IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return new ArrayList<>();
    }
}
