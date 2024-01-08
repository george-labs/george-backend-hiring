import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String filename = null;
        if (args.length > 0) {
            filename = args[0].trim();
        }

        List<String> lines;
        if (filename != null && !filename.isEmpty()) {
            lines = Files.readAllLines(Path.of(filename));
        } else {
            System.out.println("Enter text:");
            String inputText = scanner.nextLine();
            lines = new ArrayList<>();
            lines.add(inputText);
        }

        WordCounter wordCounter = new WordCounter(lines);
        System.out.println("Number of words: " + wordCounter.count() + ", unique: " + wordCounter.unique());

    }
}
