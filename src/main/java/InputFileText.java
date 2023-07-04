import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InputFileText {

    private List<String> inputFileText;

    public void setInputFileText(List<String> inputFileText) {
        this.inputFileText = inputFileText;
    }

    public List<String> getInputFileText() {
        return inputFileText;
    }

    public List<String> readingFromWorkDirectory(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("There are no file provided");
        }
        return lines;
    }
}
