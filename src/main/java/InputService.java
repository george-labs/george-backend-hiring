import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InputService {
    private static final String EMPTY_FILE = "Empty File";
    private static final String EMPTY_STRING = "";
    String getInput(String input) {
        try {
            if (!input.isEmpty()) {
                Path of = Path.of(input);
                if (Files.exists(of)) {
                    return Files.readString(of);
                } else {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter text: ");
                    return scanner.nextLine();
                }
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter text: ");
                return scanner.nextLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return EMPTY_STRING;
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
            System.out.println(EMPTY_FILE);
            return EMPTY_STRING;
        }
    }



}
