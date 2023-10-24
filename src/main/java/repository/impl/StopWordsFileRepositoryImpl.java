package repository.impl;

import repository.StopWordsRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsFileRepositoryImpl implements StopWordsRepository {

    private final String fileName;


    public StopWordsFileRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Set<String> fetchAll() {
        return fetchAllByFilename(fileName);
    }

    private Set<String> fetchAllByFilename(String fileName) {
        try (InputStream inputStream = getFileFromResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            System.err.println("Can't read the file: " + fileName);
            throw new RuntimeException(e);
        }
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
