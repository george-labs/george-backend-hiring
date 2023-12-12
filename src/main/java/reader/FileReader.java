package reader;

import exceptions.WordCountException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class FileReader {

    private String pathToFile;

//    public FileReader() {
//    }

    public FileReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Collection<String> read() {
        try {
            return Files.readAllLines(resolvePath());
        } catch (IOException e) {
            String errorMessage = "We have troubles reading the file!";
            System.out.println(errorMessage);
            throw new WordCountException(errorMessage);
        }
    }

    @NotNull
    public Path resolvePath() {
        return Paths.get(pathToFile);
    }
}
