package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderUtil {
    private final String fileName;
    private final String BASE_PATH = "src/main/resources/";

    public FileReaderUtil(String fileName) {
        this.fileName = fileName;
    }

    public String readLineByLine() throws IOException {
        final byte[] bytes;
        if (fileName != null) {
            bytes = Files.readAllBytes(Path.of(BASE_PATH+ fileName));
            return new String(bytes);
        }
        return null;
    }

}
