package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileInputReader implements InputReader{

    private final String fileName;

    public FileInputReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> readAndGetData() {
        Path filePath = Paths.get(fileName);

        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println(e);
        }

        return List.of();
    }
}
