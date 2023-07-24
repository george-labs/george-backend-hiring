import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class JavaApplicationTest {
    @Test
    void should_PrintWordCount_When_InputTextProvidedByConsole() {
        String input = "Mary had a little lamb";
        String output = "Number of words: 5";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        JavaApplication.main(new String[]{});
        Assertions.assertTrue(outputStream.toString().contains(output));
    }
}
