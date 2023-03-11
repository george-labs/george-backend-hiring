import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class TextFileReader {

    public static Function<List<String>, String> JOIN_FUNCTION = s -> String.join(" ", s);

    public static List<String> read(String inputFile) throws FileNotFoundException {
        File f = new File(inputFile);
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            return lines;
        }
    }

    public static String read(String inputFile, Function<List<String>, String> function) throws FileNotFoundException {
       return function.apply(read(inputFile));
    }
}
