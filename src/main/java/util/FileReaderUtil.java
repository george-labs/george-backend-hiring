package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderUtil {
    private String fileName;

    public FileReaderUtil(String fileName) {
        this.fileName = fileName;
    }

    public String readLineByLine() throws IOException {
        final byte[] bytes;
        if (fileName != null) {
            bytes = Files.readAllBytes(Path.of(fileName));
            return new String(bytes);

        }
    }
}
