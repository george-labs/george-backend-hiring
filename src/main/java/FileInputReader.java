import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInputReader implements InputReader {

    String filePathString;

    FileInputReader(String filePathString) {
        this.filePathString = filePathString;
    }

    @Override
    public String readInput() throws IOException {
        return Files.readString(Paths.get(filePathString));
    }
}