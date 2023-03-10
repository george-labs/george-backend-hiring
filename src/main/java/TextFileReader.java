import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader {

    public String read(String inputFile) throws FileNotFoundException {
        List<String> text = new ArrayList<>();
        File fileReader = new File(inputFile);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
        }
        return String.join(" ", text);
    }
}
