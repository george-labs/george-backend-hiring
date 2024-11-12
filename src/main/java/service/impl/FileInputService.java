package service.impl;

import service.InputService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputService implements InputService {
    private static String FILE_PATH = "src/main/resources/stopwords.txt";

    @Override
    public String getInput() throws IOException {
        try {
            Path path = Path.of(FILE_PATH);
            return Files.readString(path);
        } catch (IOException e) {
            throw e;
        }
    }
}
