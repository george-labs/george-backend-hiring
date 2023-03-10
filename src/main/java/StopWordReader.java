import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StopWordReader {

    private List<String> lines = new ArrayList<>();
    Scanner scanner;

    public StopWordReader(String inputFile) throws IOException {
        File fileReader = new File(inputFile);
        scanner = new Scanner(fileReader);
    }

    public int read() {
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return lines.size();
    }

    public List<String> getWordsToFilterOut() {
        return Collections.unmodifiableList(lines);
    }
}
