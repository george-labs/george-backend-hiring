package service.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FileReader implements Reader {

    @Override
    public String readInput() {
        Set<String> wordSet = new HashSet<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("stopwords.txt")) {
            if (is != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                    String currentLine = reader.readLine();
                    while (currentLine != null) {
                        wordSet.add(currentLine);
                        currentLine = reader.readLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordSet.isEmpty() ? "" : String.join(" ", wordSet);
    }
}
