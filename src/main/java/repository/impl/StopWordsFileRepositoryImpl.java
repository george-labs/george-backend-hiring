package repository.impl;

import repository.StopWordsRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class StopWordsFileRepositoryImpl implements StopWordsRepository {

    private final static String FILENAME = "stopwords.txt";

    @Override
    public List<String> fetch() {
        InputStream fileFromResourceAsStream = getFileFromResourceAsStream(FILENAME);
        fileFromResourceAsStream.
        return null;
    }

    private List<String> getListOfStrings(InputStream inputStream) {
        //TODO read from the BufferedReader!
        //TODO should I close the InputStream in getFileFromResourceAsStream?
        //BufferedReader r = new BufferedReader(new InputStreamReader(is));
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + fileName);
            } else {
                return inputStream;
            }
        } catch (IOException e) {
            System.err.println("Can't read the file: " + fileName);
            throw new RuntimeException(e);
        }
    }
}
