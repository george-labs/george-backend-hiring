import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JavaApplication {
    public static void main(String[] args) throws FileNotFoundException {
        Example example;
        InputStream input = null;
        try {
            if (args.length == 1) {
                try {
                    input = new FileInputStream(fileName);
                    example = new ExampleWithFileInput(input, System.out);
                } catch (FileNotFoundException e) {
                    System.out.println(String.format("File [%s] doesn't exist", fileName));
                }
            } else {
                new ExampleWithUserInput(System.in, System.out).run();

            }
            if (input == null) {
                // fallback to manual text input

            }
    }

    private static FileInputStream getFileInputStream(String fileName) {
        try {

        } catch (FileNotFoundException e) {

            return null;
        }
    }
}
