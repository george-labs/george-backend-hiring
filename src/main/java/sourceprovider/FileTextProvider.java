package sourceprovider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTextProvider implements TextProvider {
    private String filePath;

    public FileTextProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String provide() {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
