import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JavaApplication {
    public static void main(String[] args) {
        if (args.length == 1) {
            runWithFileInput(args);
        } else {
            runWithUserInput();
        }
    }

    private static void runWithFileInput(String[] args) {
        try (InputStream input = JavaApplication.class.getClassLoader().getResourceAsStream(args[0])) {
            new WordProcessorWithFileInput(input, System.out).process();
        } catch (FileNotFoundException e) {
            System.err.printf("File [%s] doesn't exist%n", args[0]);
        } catch (IOException e) {
            System.err.println("Input stream cannot be closed");
        }
    }

    private static void runWithUserInput() {
        new WordProcessorWithUserInput(System.in, System.out).process();
    }
}
