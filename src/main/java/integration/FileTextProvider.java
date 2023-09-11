package integration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileTextProvider implements ITextProvider {
    private final String fileName;

    public FileTextProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getString() {
        String file = Objects.requireNonNull(FileTextProvider.class.getClassLoader().getResource(fileName)).getFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            reader.lines().forEach(line -> builder.append(line).append(" "));
            return builder.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
