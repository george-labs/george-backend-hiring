package service;

import exception.InvalidInputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StopWordServiceImpl implements StopWordService {

    private String stopWordPath;

    public StopWordServiceImpl(String stopWordPath) {
        this.stopWordPath = stopWordPath;
    }

    @Override
    public List<String> getIgnoredWords() {
        try {
            return Files.readAllLines(Path.of(stopWordPath));
        } catch (IOException e) {
            throw new InvalidInputException("File could not be found");
        }
    }
}
