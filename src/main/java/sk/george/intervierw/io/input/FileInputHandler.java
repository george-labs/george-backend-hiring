package sk.george.intervierw.io.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sk.george.intervierw.exception.NonRecoverableException;

public class FileInputHandler implements InputHandler {
    private final Logger logger = Logger.getLogger(FileInputHandler.class.getName());

    @Override
    public String loadSingle(String path) throws NonRecoverableException {
        // TODO: Implement file reading as a single input string
        return null;
    }

    @Override
    public List<String> loadMultiple(String path) throws NonRecoverableException {
        // Create a FilePath for the given path
        Path filePath = Paths.get(path);

        try {
            // Read all lines from the file
            return Files.readAllLines(filePath);
        } catch (IOException | SecurityException  exc) {
            logger.log(Level.SEVERE, String.format("Cannot read the file input on given path: %s", path));
            throw new NonRecoverableException(exc);
        }
    }
}
