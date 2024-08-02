package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileReader {

    public FileReader() {
    }

    public List<String> readFile(String filePath) {
        Path path = Paths.get(filePath);
        List<String> lines = new LinkedList<>();
        try {
            lines = Files.readAllLines(path);
        }
        catch (NoSuchFileException ex) {
            System.out.println("File was not found: " + ex);
        }
        catch (IOException ex) {
            System.out.println("exception occured during the file read: " + ex);

        }
        return lines;
    }
}
