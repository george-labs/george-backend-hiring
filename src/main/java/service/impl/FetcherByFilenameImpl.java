package service.impl;

import model.Input;
import service.Fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FetcherByFilenameImpl implements Fetcher {

    private final String filename;

    public FetcherByFilenameImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public Input fetch() {
        List<String> words = fetchAllByFilename(filename);
        String wordsString = String.join(" ", words);
        return new Input(wordsString);
    }

    private List<String> fetchAllByFilename(String fileName) {
        try (InputStream inputStream = getFileFromResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .collect(Collectors.toList());
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
