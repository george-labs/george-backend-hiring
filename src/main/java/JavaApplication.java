import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JavaApplication {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) {
            runWithFileInput(args);
        } else {
            runWithUserInput();
        }
    }

    private static void runWithFileInput(String[] args) {
        try (InputStream input = new FileInputStream(args[0])) {
            new WordProcessorWithFileInput(input, System.out).process();
        } catch (FileNotFoundException e) {
            System.err.println(String.format("File [%s] doesn't exist", args[0]));
        } catch (IOException e) {
            System.err.println(String.format("Input stream cannot be closed", args[0]));
        }
    }

    private static void runWithUserInput() {
        new WordProcessorWithUserInput(System.in, System.out).process();
    }
}
