import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelectiveWordParser extends NaturalWordParser {

    private final Set<String> stopWords;

    public SelectiveWordParser() {

        try (InputStream inputStream = SelectiveWordParser.class.getResourceAsStream("stopwords.txt")) {

            stopWords = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected boolean validateWord(String word) {
        if (stopWords.contains(word)) {
            return false;
        }
        return super.validateWord(word);
    }
}
