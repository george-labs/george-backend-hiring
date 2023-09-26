package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileHandler {
    public String readFileToString(String fileName) {
        var classLoader = getClass().getClassLoader();
        var inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new FileHandlingException("File not found: " + fileName);
        }
        try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new FileHandlingException("Failed to read file: " + fileName);
        }

    }
}
