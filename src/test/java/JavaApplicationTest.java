import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @Test
    public void test() {
        JavaApplication.main("src/test/resources/input.txt");
    }

    @Test
    public void testConsoleInput() throws Exception {
        try (
                FileInputStream fileInputStream = new FileInputStream("src/test/resources/input.txt");
                PipedOutputStream outputStream = new PipedOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                PipedInputStream pipedInputStream = new PipedInputStream(outputStream);

        ) {


            System.setOut(printStream);

            System.setIn(fileInputStream);

            JavaApplication.main();

            Scanner scanner = new Scanner(pipedInputStream);
            String result = scanner.nextLine();
//            assertEquals("Mary had a little lamb", result);


            assertEquals("Enter text:\nMary had a little lamb", result);
        }
    }
}
