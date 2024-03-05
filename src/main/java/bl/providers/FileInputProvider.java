package bl.providers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileInputProvider implements InputProvider {

    private final String fileName;

    public FileInputProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getInput() {
        try {
            return Files.readString(Path.of(fileName));
        } catch (NoSuchFileException e) {
            System.out.println("File \"" + fileName + "\" does not exist.");
            throw new IllegalArgumentException("File \"" + fileName + "\" does not exist.", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + fileName, e);
        }
    }
}
