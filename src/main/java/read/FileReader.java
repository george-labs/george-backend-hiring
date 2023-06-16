package read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader extends Reader {

    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Stream<String> read() throws IOException {
        return Files.lines(Paths.get(this.fileName));
    }
}
