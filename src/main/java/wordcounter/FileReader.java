package wordcounter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FileReader {

    public List<String> readFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resource = classLoader.getResourceAsStream(fileName);

        if (resource == null) {
            throw new RuntimeException(String.format("File '%s' not found", fileName));
        }

        return new BufferedReader(new InputStreamReader(resource))
                .lines()
                .toList();
    }

}
