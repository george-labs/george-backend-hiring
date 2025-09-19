import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Input {

    public static String wordsFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String wordsFromConsole() {
        // "wor3d word" = per regex in description will be split to wor, d, word

        System.out.println("Enter text:");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
