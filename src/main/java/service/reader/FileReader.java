package service.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FileReader {

    public String readInput(String filename) {
        Set<String> wordSet = new HashSet<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (is != null && is.available() == 0) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                    String currentLine = reader.readLine();
                    while (currentLine != null) {
                        wordSet.add(currentLine);
                        currentLine = reader.readLine();
                    }
                }
            } else {
                throw new RuntimeException("File could not be loaded");
            }
        } catch (IOException e) {
            throw new RuntimeException("File could not be loaded", e);
        }
        return wordSet.isEmpty() ? "" : String.join(" ", wordSet);
    }
}
