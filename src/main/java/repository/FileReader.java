package repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileReader {
    public FileReader() {
    }


    public List<String> loadFile(String pathToFile) {
        try {
            var path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(pathToFile)).toURI());

            return Files.readAllLines(path);

        } catch (URISyntaxException | IOException | NullPointerException e) {
            System.out.println("There was exception during reading of file");
            throw new RuntimeException(e);
        }
    }

}
