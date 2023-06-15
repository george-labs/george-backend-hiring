import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestHelper {
    public static String generateOutput(String userInput, String[] args) {

        InputStream stdin = System.in;
        PrintStream stdout = System.out;

        ByteArrayInputStream testInput = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));

        JavaApplication.main(args);

        System.setIn(stdin);
        System.setOut(stdout);

        return testOutput.toString().trim();
    }

    public static String generateOutputWithInput(String userInput) {
        return TestHelper.generateOutput(userInput, new String[]{});
    }

    public static String generateOutputWithFile(String fileName) {
        return TestHelper.generateOutput("", new String[]{fileName});
    }
}
