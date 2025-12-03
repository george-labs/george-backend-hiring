package service;

import exception.InvalidInputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputService implements UserInputService {

    private String pathArgument;

    public FileInputService(String pathArgument) {
        this.pathArgument = pathArgument;
    }

    @Override
    public String getUserInput() {
        try {
            return Files.readString(Path.of(pathArgument));
        } catch (IOException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
