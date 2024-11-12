package service.impl;

import service.InputService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputService implements InputService {
    private final String filePath;

    public FileInputService(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getInput() throws IOException {
        try {
            Path path = Path.of(filePath);
            return Files.readString(path);
        } catch (IOException e) {
            throw e;
        }
    }
}
