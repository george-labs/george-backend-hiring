package counter.processor;


import counter.WordCounter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Process input as path to file. And in second step checks words from file content.
 */
public class FileWordCounterProcessor extends AbstractProcessor {
    public FileWordCounterProcessor(WordCounter wordCounter) {
        super(wordCounter);
    }

    @Override
    public String process(String input) {
        final String text = readFromFile(input);
        return processInternal(text);
    }

    private String readFromFile(String input) {
        Path path = Paths.get(input);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            System.err.println("Could not read file: " + input);
            throw new IllegalArgumentException("Could not read file: " + e.getMessage(), e);
        }
    }
}
