package service.stop_word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordProvider implements IStopWordProvider {
    private final String fileName;

    public StopWordProvider() {
        fileName = "stopwords.txt";
    }

    public StopWordProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Set<String> getStopWords() {
        URL url = StopWordProvider.class.getClassLoader().getResource(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(Objects.requireNonNull(url).getFile()))) {
            return reader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
