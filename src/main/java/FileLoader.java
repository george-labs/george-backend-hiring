import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader {

    public List<String> loadFile(String fileName) {

        BufferedReader reader;
        List<String> result;
        try {
            Path path2 = Paths.get(getClass().getClassLoader()
                    .getResource(fileName).toURI());
            reader = new BufferedReader(new FileReader(path2.toFile()));
            result = reader.lines().toList();
            reader.close();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
