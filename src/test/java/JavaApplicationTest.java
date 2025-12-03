import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

public class JavaApplicationTest {

    @Test
    public void testMain() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        JavaApplication.main(new String[]{"src/test/resources/testFile.txt"});

        Assertions.assertEquals("Number of words: 4, unique: 4", outputStream.toString());
    }
}
