package input.impl;

import input.StopWordsProvider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.util.HashSet;
import java.util.Set;

public class FileStopWordsProvider implements StopWordsProvider {

    @Override
    public Set<String> getStopWords(String filename) throws NoSuchFileException {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Path must not be null!");
        }

        Set<String> stopWords = new HashSet<>();
        filename = "/" + filename;

        try (InputStream inputStream = getClass().getResourceAsStream(filename)) {
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                stopWords.add(line);
            }
        }
        catch (NullPointerException e) {
            throw new NoSuchFileException("File with name: " + filename + " doesnt exists");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return stopWords;
    }

}
