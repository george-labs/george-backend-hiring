package wordcount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StopWordsLoader {
    public Set<String> loadStopWords(String filename) {
        Set<String> stopWords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                stopWords.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }
}
