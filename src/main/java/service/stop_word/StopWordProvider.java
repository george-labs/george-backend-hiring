package service.stop_word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordProvider implements IStopWordProvider {
    private static final String FILE_PATH = "stopwords.txt";

    @Override
    public Set<String> getStopWords() {
        URL url = StopWordProvider.class.getClassLoader().getResource(FILE_PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(Objects.requireNonNull(url).getFile()))) {
            return reader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
