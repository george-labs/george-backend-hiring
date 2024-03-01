package repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements StopWordsProvider{
    private List<String> stopWords;

    public FileReader(String pathToFile){
        this.loadFile(pathToFile);
    }


    public void loadFile(String pathToFile){
        try {
            var path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(pathToFile)).toURI());

            Stream<String> lines = Files.lines(path);
            this.stopWords = lines.collect(Collectors.toList());
            lines.close();

        } catch (URISyntaxException | IOException e) {
            System.out.println("There was exception during reading of file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<String> provideStopWords() {
        return stopWords;
    }

}
