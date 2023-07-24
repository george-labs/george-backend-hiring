package com.quiz.reader;

import com.quiz.exception.WordCountFileNotFoundException;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader implements Reader {

    private final String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String read() {
        try {
            Path path;
            if (fileName.contains("/")) {
                path = Path.of(fileName);
            } else {
                path = Path.of(ClassLoader.getSystemResource(fileName).toURI());
            }
            return Files.readString(path);
        } catch (Exception ex) {
            throw new WordCountFileNotFoundException(ex.getMessage());
        }
    }
}
