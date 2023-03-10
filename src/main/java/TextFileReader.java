import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TextFileReader {
    private List<String> lines = new ArrayList<>();
    private File inputFile;

    public TextFileReader(String inputFile) {
        this.inputFile = new File(inputFile);
    }

    public String read() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            return String.join(" ", lines);
        }
    }

    public List<String> getWordsToFilterOut() {
        return Collections.unmodifiableList(lines);
    }
}
