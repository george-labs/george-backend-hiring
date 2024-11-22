package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileReader implements InputSource{

    private  final String inputFileName;

    public FileReader(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    @Override
    public String getInput() {
        return getInputFromFile(inputFileName);
    }

    private String getInputFromFile(String fileName) {
        Path path = Paths.get(fileName);
        List<String> lines;
        try {
           lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new InputReadException("Error when reading the file");
        }
        return String.join(" ", lines);


    }

    @Override
    public void close() throws IOException {

    }
}
